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
import com.example.demo.entity.Trip;
import com.example.demo.service.ITripService;


@RestController
@RequestMapping("/api")
public class TripController {
	
	
	ITripService iTripService;
	
	

	 
	public TripController(ITripService iTripService) {
		super();
		this.iTripService = iTripService;
	}







	@GetMapping("/trip/{id}")
	public ResponseEntity<Trip> getTripById(@PathVariable Long id)
	{
		Optional<Trip> trip = iTripService.getTripById(id);
		
		if(trip.isPresent()) {
			return new ResponseEntity<>(trip.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@PostMapping("/trips")
	public ResponseEntity<Trip> addTrip(@RequestBody  @Valid  Trip trip){
		try {
			return new ResponseEntity<Trip>(iTripService.addTrip(trip),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/trips")
	public ResponseEntity<Trip> updateTrip(@RequestBody @Valid Trip trip){
		try {
			return new ResponseEntity<Trip>(iTripService.updateTrip(trip),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/trip/{id}")
	public ResponseEntity<HttpStatus> deleteTrip(@PathVariable Long id){
		try {
			iTripService.deleteTrip(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GetMapping("/trips")
	  public ResponseEntity<Map<String, Object>> getAllployees(
	        @RequestParam(required = false) String driver,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<Trip> trips = new ArrayList<Trip>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Trip> pageTrips;
	      if (driver == null ) 
	        pageTrips = iTripService.findAll(paging);
	      
	      else 
	  	        pageTrips = iTripService.findByDriver(driver, paging);
		
	      

	      
	      trips = pageTrips.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("trips", trips);
	      response.put("currentPage", pageTrips.getNumber());//for current Page.
	      response.put("totalItems", pageTrips.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageTrips.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 
	  

}
