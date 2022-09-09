package com.example.demo.serviceImpl;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Trip;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.ITripService;



@Service
public class TripServiceImpl implements ITripService{
	
	@Autowired
	TripRepository tripRepository;

	
	@Override
	public Optional<Trip> getTripById(Long id) {
		// TODO Auto-generated method stub
		return tripRepository.findById(id);
	}

	@Override
	public void deleteTrip(Long tripId) {
		if(getTripById(tripId).isPresent())
		{
			tripRepository.delete(getTripById(tripId).get());
		}
		
	}

	@Transactional
	@Override
	public Trip addTrip(Trip trip) {
		// TODO Auto-generated method stub
		return tripRepository.save(trip);
	}

	@Transactional
	@Override
	public Trip updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Trip> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tripRepository.findAll(pageable);
	}

	@Override
	public Page<Trip> findByDriver(String driver, Pageable pageable) {
		// TODO Auto-generated method stub
		return tripRepository.findByDriver(driver, pageable);
	}
	
 

	 

}
