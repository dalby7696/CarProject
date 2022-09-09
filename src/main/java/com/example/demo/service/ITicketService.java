package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Ticket;



public interface ITicketService {
	 
	 Optional<Ticket> getTicketById(Long id) ;
	 void deleteTicket(Long ticketId) ;
	 Ticket addTicket(Ticket ticket) ;
	 Ticket updateTicket(Ticket ticket) ;
	 
	 Page<Ticket> findAll(Pageable pageable);
	Page <Ticket> findByCustomerName(String customerName, Pageable pageable);
	 
	 
	  
	 
	  

}
