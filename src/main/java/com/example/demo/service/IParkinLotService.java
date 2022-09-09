package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.ParkingLot;



public interface IParkinLotService {
	  
	 Optional<ParkingLot> getParkingLotById(Long id) ;
	 void deleteParkingLot(Long parkingLotId) ;
	 ParkingLot addParkingLot(ParkingLot parkingLot) ;
	 ParkingLot updateParkingLot(ParkingLot parkingLot) ;
	 
	 
	 
	 Page<ParkingLot> findAll(Pageable pageable);
	 Page <ParkingLot> findByParkPlace(String parkPlace, Pageable pageable);
	 Page <ParkingLot> findByParkName(String parkName, Pageable pageable);
	 
	  

}
