package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long tripId;
	
	@Column(length = 11)
	private int bookedticketNumber;
	
	@Column(length = 11)
	@NotBlank(message = "carType is mandatory")
	private String carType;
	
	//@NotBlank(message = "departureDate is mandatory")
	private Date departureDate;
	
	//@NotBlank(message = "departureTime is mandatory")
	private Date departureTime;
	
	@Column(length = 50)
	@NotBlank(message = "destination is mandatory")
	private String destination;
	
	@Column(length = 11)
	@NotBlank(message = "driver  is mandatory")
	private String driver;
	
	@Column(length = 11)
	//@NotEmpty(message = "Please Select Online Ticket Number ")
	//@Min(value = 5, message = "Please input data between 5 and 50")
	//@Max(value = 50, message = "Please input data between 5 and 50")
	private int maximumOnlineTicketNumber;
	
	@OneToMany(mappedBy = "trip",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference
	private Set<Ticket> tickets ;
	
	@OneToMany(mappedBy = "trip" ,  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<BookingOffice> bookingOffice ;

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trip(Long tripId, int bookedticketNumber, String carType,
			Date departureDate, Date departureTime,  String destination,
			 String driver, int maximumOnlineTicketNumber,
			Set<Ticket> tickets, List<BookingOffice> bookingOffice) {
		super();
		this.tripId = tripId;
		this.bookedticketNumber = bookedticketNumber;
		this.carType = carType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.destination = destination;
		this.driver = driver;
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
		this.tickets = tickets;
		this.bookingOffice = bookingOffice;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public int getBookedticketNumber() {
		return bookedticketNumber;
	}

	public void setBookedticketNumber(int bookedticketNumber) {
		this.bookedticketNumber = bookedticketNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getMaximumOnlineTicketNumber() {
		return maximumOnlineTicketNumber;
	}

	public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<BookingOffice> getBookingOffice() {
		return bookingOffice;
	}

	public void setBookingOffice(List<BookingOffice> bookingOffice) {
		this.bookingOffice = bookingOffice;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", bookedticketNumber=" + bookedticketNumber + ", carType=" + carType
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", destination="
				+ destination + ", driver=" + driver + ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber
				+ ", tickets=" + tickets + ", bookingOffice=" + bookingOffice + "]";
	}

	 
	
	
	
}
