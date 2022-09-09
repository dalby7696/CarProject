package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
	
	Page<Trip> findAll(Pageable pageable);
	Page <Trip> findByDriver(String driver, Pageable pageable);
	

}
