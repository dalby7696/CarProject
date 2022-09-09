package com.example.demo.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 


@Entity
 
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long ticketId;
	
	 
	private Instant bookingTime = Instant.now();
	
	
	@NotBlank(message = "customerName Name is mandatory")
	@Column(length = 11)
	private String customerName;
	
	
	@ManyToOne//(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "trip_id", referencedColumnName = "tripId")// @JoinColumn annotation to specify the foreign key column(tripId)
	 //@JsonIgnore //@JsonIgnore is used to ignore the logical property used in serialization and deserialization.
	//@JsonBackReference
	private Trip trip;
	
	
	@ManyToOne//(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "license_plate", referencedColumnName ="licensePlate" )// @JoinColumn annotation to specify the foreign key column(tripId)
	//@JsonBackReference
	// @JsonIgnore //@JsonIgnore is used to ignore the logical property used in serialization and deserialization.
	 private Car car;


	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ticket(Long ticketId, String customerName, Trip trip, Car car) {
		super();
		this.ticketId = ticketId;
		 
		this.customerName = customerName;
		this.trip = trip;
		this.car = car;
	}


	public Long getTicketId() {
		return ticketId;
	}


	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}


	public Instant getBookingTime() {
		return bookingTime;
	}


	public void setBookingTime(Instant bookingTime) {
		this.bookingTime = bookingTime;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


//	public Trip getTrip() {
//		return trip;
//	}
//
//
//	public void setTrip(Trip trip) {
//		this.trip = trip;
//	}
//
//
//	public Car getCar() {
//		return car;
//	}
//
//
//	public void setCar(Car car) {
//		this.car = car;
//	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
				+ ", trip=" + trip + ", car=" + car + "]";
	}


	 


	
}
