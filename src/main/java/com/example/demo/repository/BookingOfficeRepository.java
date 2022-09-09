package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookingOffice;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long>{

	Page<BookingOffice> findAll(Pageable pageable);
	Page <BookingOffice> findByOfficeName(String officeName, Pageable pageable);
	Page <BookingOffice> findByOfficePhone(String officePhone, Pageable pageable);
	Page <BookingOffice> findByOfficePlace(String officePlace, Pageable pageable);
}
