package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.BookingOffice;




public interface IBookingOfficeService {
	 
	 Optional<BookingOffice> getBookingOfficeById(Long id) ;
	 void deleteBookingOffice(Long bookingOfficeId) ;
	 BookingOffice addBookingOffice(BookingOffice bookingOffice) ;
	 BookingOffice updateBookingOffice(BookingOffice bookingOffice) ;
	 
	 
	 
	    Page<BookingOffice> findAll(Pageable pageable);
		Page <BookingOffice> findByOfficeName(String officeName, Pageable pageable);
		Page <BookingOffice> findByOfficePhone(String officePhone, Pageable pageable);
		Page <BookingOffice> findByOfficePlace(String officePlace, Pageable pageable);
	  

}
