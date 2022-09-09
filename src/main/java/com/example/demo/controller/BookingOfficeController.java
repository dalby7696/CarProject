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
import com.example.demo.entity.BookingOffice;
import com.example.demo.service.IBookingOfficeService;
 


@RestController
@RequestMapping("/api")
public class BookingOfficeController {
	
	
	IBookingOfficeService iBookingOfficeService;
	
	
	
	
	public BookingOfficeController(IBookingOfficeService iBookingOfficeService) {
		super();
		this.iBookingOfficeService = iBookingOfficeService;
	}




	@GetMapping("/bookingOffice/{id}")
	public ResponseEntity<BookingOffice> getBookingOfficeById(@PathVariable Long id)
	{
		Optional<BookingOffice> BookingOffice = iBookingOfficeService.getBookingOfficeById(id);
		
		if(BookingOffice.isPresent()) {
			return new ResponseEntity<>(BookingOffice.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 
	
	
	
	
	@PostMapping("/bookingOffices")
	public ResponseEntity<BookingOffice> addBookingOffice(@RequestBody  @Valid  BookingOffice bookingOffice){
		try {
			return new ResponseEntity<BookingOffice>(iBookingOfficeService.addBookingOffice(bookingOffice),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/bookingOffices")
	public ResponseEntity<BookingOffice> updateBookingOffice(@RequestBody @Valid BookingOffice bookingOffice){
		try {
			return new ResponseEntity<BookingOffice>(iBookingOfficeService.updateBookingOffice(bookingOffice),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/bookingOffice/{id}")
	public ResponseEntity<HttpStatus> deleteBookingOffice(@PathVariable Long id){
		try {
			iBookingOfficeService.deleteBookingOffice(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	 
	@GetMapping("/bookingOffices")
	  public ResponseEntity<Map<String, Object>> getAllBookingOffices(
	        
	        @RequestParam(required = false) String officePhone,
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<BookingOffice> bookingOffices = new ArrayList<BookingOffice>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<BookingOffice> pageBookingOffices;
	      if (officePhone == null && name == null  ) {
	        pageBookingOffices = iBookingOfficeService.findAll(paging);
	      }
	      else if (officePhone != null && name == null  ) {
	  	        pageBookingOffices = iBookingOfficeService.findByOfficePhone(officePhone, paging);
	      }
	      else {
	    	   pageBookingOffices = iBookingOfficeService.findByOfficeName(name, paging);
	      }
	      
	      bookingOffices = pageBookingOffices.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("BookingOffices", bookingOffices);
	      response.put("currentPage", pageBookingOffices.getNumber());//for current Page.
	      response.put("totalItems", pageBookingOffices.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageBookingOffices.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  
	  

}
