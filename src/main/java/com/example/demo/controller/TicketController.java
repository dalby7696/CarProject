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
import com.example.demo.entity.Ticket;
import com.example.demo.service.ITicketService;



@RestController
@RequestMapping("/api")
public class TicketController {
	

	ITicketService iTicketService;

	 
	public TicketController(ITicketService iTicketService) {
		super();
		this.iTicketService = iTicketService;
	}




	@GetMapping("/ticket/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long id)
	{
		Optional<Ticket> Ticket = iTicketService.getTicketById(id);
		
		if(Ticket.isPresent()) {
			return new ResponseEntity<>(Ticket.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 
	
	
	
	
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> addTicket(@RequestBody  @Valid  Ticket ticket){
		try {
			
			return new ResponseEntity<Ticket>(iTicketService.addTicket(ticket),HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/tickets")
	public ResponseEntity<Ticket> updateTicket(@RequestBody @Valid Ticket ticket){
		try {
			return new ResponseEntity<Ticket>(iTicketService.updateTicket(ticket),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/ticket/{id}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable Long id){
		try {
			iTicketService.deleteTicket(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GetMapping("/tickets")
	  public ResponseEntity<Map<String, Object>> getAllTickets(
	        @RequestParam(required = false) String customerName,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<Ticket> tickets = new ArrayList<Ticket>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Ticket> pageTickets;
	      if (customerName == null ) 
	        pageTickets = iTicketService.findAll(paging);
	      
	      else 
	  	        pageTickets = iTicketService.findByCustomerName(customerName, paging);
		
	      

	      
	      tickets = pageTickets.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("Tickets", tickets);
	      response.put("currentPage", pageTickets.getNumber());//for current Page.
	      response.put("totalItems", pageTickets.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageTickets.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 
	  

}
