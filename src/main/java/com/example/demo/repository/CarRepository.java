package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;
import com.example.demo.entity.Employee;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {//CrudRep
	
	Page<Car> findAll(Pageable pageable);
	Page <Car> findByCompany(String company, Pageable pageable);
	Page <Car> findByCarColor(String carColor, Pageable pageable);
	Page <Car> findByCarType(String carType, Pageable pageable);

}
