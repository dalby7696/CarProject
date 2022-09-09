package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.example.demo.entity.Car;
import com.example.demo.service.ICarService;


@RestController
@RequestMapping("/api")
public class CarController {
	
 
	private ICarService iCarService;
	
	

	 
	public CarController(ICarService iCarService) {
		super();
		this.iCarService = iCarService;
	}







	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id)
	{
		Optional<Car> car = iCarService.getCarById(id);
		
		if(car.isPresent()) {
			return new ResponseEntity<>(car.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 
	
	
	
	
	@PostMapping("/cars")
	public ResponseEntity<Car> addCar(@RequestBody  @Valid  Car car){
		try {
			return new ResponseEntity<Car>(iCarService.addCar(car),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/cars")
	public ResponseEntity<Car> updateCar(@RequestBody Car car){
		try {
			return new ResponseEntity<Car>(iCarService.updateCar(car),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id){
		try {
			iCarService.deleteCar(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@GetMapping("/cars")
	  public ResponseEntity<Map<String, Object>> getAllCars(
	        @RequestParam(required = false) String carColor,
	        @RequestParam(required = false) String company,
	        @RequestParam(required = false) String carType,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<Car> cars = new ArrayList<Car>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Car> pageCars;
	      if (carColor == null && company==null && carType==null) {
	    	  pageCars = iCarService.findAll(paging);
		      }
		      else if (carColor == null && company!=null && carType==null) {
		    	  pageCars = iCarService.findByCompany(company, paging);
		      }
		      else if (carColor == null && company==null && carType!=null) {
		    	  pageCars = iCarService.findByCarType(carType, paging);
		      }
		      
		    else {
		    	pageCars = iCarService.findByCarColor(carColor, paging);
			}
		
	          
	      cars = pageCars.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("Cars", cars);
	      response.put("currentPage", pageCars.getNumber());//for current Page.
	      response.put("totalItems", pageCars.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageCars.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 
	  

}
