package com.example.demo.entity;

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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long parkId;
	
	
	@Column(length = 20)
	private Long parkArea;
	
	
	@NotBlank(message = "Parking Name is mandatory")
	@Column(length = 50)
	private String parkName;
	
	
	@NotBlank(message = "Parking Place is mandatory")
	@Column(length = 11)
	private String parkPlace;
	
	@Column(length = 20)
	private Long parkPrice;
	
	@Column(length = 50)
	private String parkStatus;
	
	@OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonManagedReference
	private List<Car> cars ;

	public ParkingLot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingLot(Long parkId, Long parkArea,  String parkName,
			 String parkPlace, Long parkPrice, String parkStatus,
			List<Car> cars) {
		super();
		this.parkId = parkId;
		this.parkArea = parkArea;
		this.parkName = parkName;
		this.parkPlace = parkPlace;
		this.parkPrice = parkPrice;
		this.parkStatus = parkStatus;
		this.cars = cars;
	}

	public Long getParkId() {
		return parkId;
	}

	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}

	public Long getParkArea() {
		return parkArea;
	}

	public void setParkArea(Long parkArea) {
		this.parkArea = parkArea;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkPlace() {
		return parkPlace;
	}

	public void setParkPlace(String parkPlace) {
		this.parkPlace = parkPlace;
	}

	public Long getParkPrice() {
		return parkPrice;
	}

	public void setParkPrice(Long parkPrice) {
		this.parkPrice = parkPrice;
	}

	public String getParkStatus() {
		return parkStatus;
	}

	public void setParkStatus(String parkStatus) {
		this.parkStatus = parkStatus;
	}

//	public List<Car> getCars() {
//		return cars;
//	}
//
//	public void setCars(List<Car> cars) {
//		this.cars = cars;
//	}

	

	
	
	
	
}
