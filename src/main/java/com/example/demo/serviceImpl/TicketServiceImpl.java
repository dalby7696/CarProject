package com.example.demo.serviceImpl;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.ITicketService;




@Service
public class TicketServiceImpl implements ITicketService{
	
	@Autowired
	TicketRepository ticketRepository;

//	 

	@Override
	public Optional<Ticket> getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id);
	}

	@Override
	public void deleteTicket(Long ticketId) {
		if(getTicketById(ticketId).isPresent()) 
		{
			ticketRepository.delete(getTicketById(ticketId).get());
		}
		
	}
	@Transactional
	@Override
	public Ticket addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Transactional
	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Page<Ticket> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ticketRepository.findAll(pageable);
	}

	@Override
	public Page<Ticket> findByCustomerName(String customerName, Pageable pageable) {
		// TODO Auto-generated method stub
		return ticketRepository.findByCustomerName(customerName, pageable);
	}

	
 

	 

}
