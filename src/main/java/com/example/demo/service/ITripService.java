package com.example.demo.service;


import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.Trip;



public interface ITripService {
	  
	 Optional<Trip> getTripById(Long id) ;
	 void deleteTrip(Long tripId) ;
	 Trip addTrip(Trip trip) ;
	 Trip updateTrip(Trip trip) ;
	 
	 
	 
	 Page<Trip> findAll(Pageable pageable);
	 Page <Trip> findByDriver(String driver, Pageable pageable);
	 
	  

}
