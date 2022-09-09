package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Car {
	 @Id
	 @Column(length = 50)
	 @NotBlank(message = "licensePlate Name is mandatory")
	private String licensePlate ;
	 
	 @Column(length = 11)
	private String carColor;
	 
	 @Column(length = 50)
	private String carType;
	 
	 @Column(length = 50)
	 @NotBlank(message = "company Name is mandatory")
	private String company;
	
	
	@ManyToOne//(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "park_id", referencedColumnName = "parkId")// @JoinColumn annotation to specify the foreign key column(tripId)
	 
	 //@JsonIgnore //@JsonIgnore is used to ignore the logical property used in serialization and deserialization.
	// @JsonBackReference
	 private ParkingLot parkingLot;
	
	
	
	@OneToMany(mappedBy = "car" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Ticket> tickets ;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car( String licensePlate, String carColor,
			String carType, String company, ParkingLot parkingLot,
			List<Ticket> tickets) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.parkingLot = parkingLot;
		this.tickets = tickets;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

//	public void setLicensePlate(String licensePlate) {
//		this.licensePlate = licensePlate;
//	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", carColor=" + carColor + ", carType=" + carType + ", company="
				+ company + ", parkingLot=" + parkingLot + ", tickets=" + tickets + "]";
	}

	 
	 
	
	
	
	
	
}
