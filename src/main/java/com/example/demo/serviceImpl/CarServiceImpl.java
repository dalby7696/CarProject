package com.example.demo.serviceImpl;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ICarService;



@Service
public class CarServiceImpl implements ICarService{
	
	@Autowired
	CarRepository carRepository;

	@Override
	public Optional<Car> getCarById(Long id) {
		// TODO Auto-generated method stub
		return carRepository.findById(id);
	}

	@Override
	public void deleteCar(Long carId) {
		if(getCarById(carId).isPresent())
		{
			carRepository.delete(getCarById(carId).get());
		}
		
	}
	
	@Transactional
	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}
	
	@Transactional
	@Override
	public Car updateCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}

	@Override
	public Page<Car> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return carRepository.findAll(pageable);
	}

	@Override
	public Page<Car> findByCompany(String company, Pageable pageable) {
		// TODO Auto-generated method stub
		return carRepository.findByCompany(company, pageable);
	}

	@Override
	public Page<Car> findByCarColor(String carColor, Pageable pageable) {
		// TODO Auto-generated method stub
		return carRepository.findByCarColor(carColor, pageable);
	}

	@Override
	public Page<Car> findByCarType(String carType, Pageable pageable) {
		// TODO Auto-generated method stub
		return carRepository.findByCarType(carType, pageable);
	}

	 

	 

}
