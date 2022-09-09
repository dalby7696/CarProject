package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Car;




public interface ICarService {
	  
	 Optional<Car> getCarById(Long id) ;
	 void deleteCar(Long carId) ;
	 Car addCar(Car car) ;
	 Car updateCar(Car car) ;
	 
	 
	 
	 	Page<Car> findAll(Pageable pageable);
		Page <Car> findByCompany(String company, Pageable pageable);
		Page <Car> findByCarColor(String carColor, Pageable pageable);
		Page <Car> findByCarType(String carType, Pageable pageable);
	  

}
