package com.example.demo.serviceImpl;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ParkingLot;
import com.example.demo.repository.ParkingLotRepository;
import com.example.demo.service.IParkinLotService;




@Service
public class ParkingLotServiceImpl implements IParkinLotService{
	
	@Autowired
	ParkingLotRepository parkingLotRepository;



	@Override
	public Optional<ParkingLot> getParkingLotById(Long id) {
		// TODO Auto-generated method stub
		return parkingLotRepository.findById(id);
	}

	@Override
	public void deleteParkingLot(Long parkingLotId) {
		if(getParkingLotById(parkingLotId).isPresent())
		{
			parkingLotRepository.delete(getParkingLotById(parkingLotId).get());
		}
		
	}

	@Transactional
	@Override
	public ParkingLot addParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return parkingLotRepository.save(parkingLot);
	}

	@Transactional
	@Override
	public ParkingLot updateParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return parkingLotRepository.save(parkingLot);
	}

	@Override
	public Page<ParkingLot> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return parkingLotRepository.findAll(pageable);
	}

	@Override
	public Page<ParkingLot> findByParkPlace(String parkPlace, Pageable pageable) {
		// TODO Auto-generated method stub
		return parkingLotRepository.findByParkPlace(parkPlace, pageable);
	}

	@Override
	public Page<ParkingLot> findByParkName(String parkName, Pageable pageable) {
		// TODO Auto-generated method stub
		return parkingLotRepository.findByParkName(parkName, pageable);
	}

	 
 

	 

}
