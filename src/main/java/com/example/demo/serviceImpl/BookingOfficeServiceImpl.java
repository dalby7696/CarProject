package com.example.demo.serviceImpl;


import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookingOffice;
import com.example.demo.repository.BookingOfficeRepository;
import com.example.demo.service.IBookingOfficeService;




@Service
public class BookingOfficeServiceImpl implements IBookingOfficeService{
	
	@Autowired
	BookingOfficeRepository bookingOfficeRepository;

	@Override
	public Optional<BookingOffice> getBookingOfficeById(Long id) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.findById(id);
	}

	@Override
	public void deleteBookingOffice(Long bookingOfficeId) {
		if(getBookingOfficeById(bookingOfficeId).isPresent())
		{
			bookingOfficeRepository.delete(getBookingOfficeById(bookingOfficeId).get());
			
		}
		
	}
	@Transactional
	@Override
	public BookingOffice addBookingOffice(BookingOffice bookingOffice) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.save(bookingOffice);
	}
	@Transactional
	@Override
	public BookingOffice updateBookingOffice(BookingOffice bookingOffice) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.save(bookingOffice);
	}

	@Override
	public Page<BookingOffice> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.findAll(pageable);
	}

	@Override
	public Page<BookingOffice> findByOfficeName(String officeName, Pageable pageable) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.findByOfficeName(officeName, pageable);
	}

	@Override
	public Page<BookingOffice> findByOfficePhone(String officePhone, Pageable pageable) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.findByOfficePhone(officePhone, pageable);
	}

	@Override
	public Page<BookingOffice> findByOfficePlace(String officePlace, Pageable pageable) {
		// TODO Auto-generated method stub
		return bookingOfficeRepository.findByOfficePlace(officePlace, pageable);
	}

	 

	 

}
