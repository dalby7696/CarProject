package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ParkingLot;
import com.example.demo.entity.Trip;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>{
	
	Page<ParkingLot> findAll(Pageable pageable);
	Page <ParkingLot> findByParkPlace(String driver, Pageable pageable);
	Page <ParkingLot> findByParkName(String driver, Pageable pageable);

}
