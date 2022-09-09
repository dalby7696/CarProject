package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ParkingLot;
import com.example.demo.service.IParkinLotService;



@RestController
@RequestMapping("/api")
public class ParkingLotController {
	
	
	IParkinLotService iParkinLotService;
	
	

	 
	public ParkingLotController(IParkinLotService iParkinLotService) {
		super();
		this.iParkinLotService = iParkinLotService;
	}




	@GetMapping("/ParkingLot/{id}")
	public ResponseEntity<ParkingLot> getParkingLotById(@PathVariable Long id)
	{
		Optional<ParkingLot> ParkingLot = iParkinLotService.getParkingLotById(id);
		
		if(ParkingLot.isPresent()) {
			return new ResponseEntity<>(ParkingLot.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 
	
	
	
	
	@PostMapping("/parkingLots")
	public ResponseEntity<ParkingLot> addParkingLot(@RequestBody  @Valid  ParkingLot parkingLot){
		try {
			return new ResponseEntity<ParkingLot>(iParkinLotService.addParkingLot(parkingLot),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/parkingLots")
	public ResponseEntity<ParkingLot> updateParkingLot(@RequestBody @Valid ParkingLot parkingLot){
		try {
			return new ResponseEntity<ParkingLot>(iParkinLotService.updateParkingLot(parkingLot),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/parkingLot/{id}")
	public ResponseEntity<HttpStatus> deleteParkingLot(@PathVariable Long id){
		try {
			iParkinLotService.deleteParkingLot(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GetMapping("/parkingLots")
	  public ResponseEntity<Map<String, Object>> getAllParkingLots(
	        @RequestParam(required = false) String parkName,
	        @RequestParam(required = false) String parkPlace,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<ParkingLot> pageParkingLots;
	      if (parkName == null && parkPlace==null ) {
	        pageParkingLots = iParkinLotService.findAll(paging);
	      }
	      else if(parkName != null && parkPlace==null ) {
	  	        pageParkingLots = iParkinLotService.findByParkName(parkName, paging);
	      }
	      else  
	      {
	    	  pageParkingLots = iParkinLotService.findByParkPlace(parkPlace, paging);
	      }
	      

	      
	      parkingLots = pageParkingLots.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("parkingLots", parkingLots);
	      response.put("currentPage", pageParkingLots.getNumber());//for current Page.
	      response.put("totalItems", pageParkingLots.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageParkingLots.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	
	  

}
