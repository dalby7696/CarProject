package com.example.demo.entity;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class BookingOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long officeId;
	
	
	private Date endContractDeadline;
	
	@Column(length = 50)
	@NotBlank(message = "office name is mandatory")
	private String officeName;
	
	@NotBlank(message = "office phone is mandatory")
	@Column(length = 11)
	private String officePhone;
	
	@NotBlank(message = "office place is mandatory")
	@Column(length = 50)
	private String officePlace;
	
	@Column(length = 20)
	private Long officePrice;
	
	
	private Date startContractDeadline;
	
	@ManyToOne//(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "trip_id", referencedColumnName = "tripId")// @JoinColumn annotation to specify the foreign key column(tripId)
	
	 
	//@JsonBackReference
	 private Trip trip;

	public BookingOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingOffice(Long officeId, Date endContractDeadline, String officeName, String officePhone,
			String officePlace, Long officePrice, Date startContractDeadline, Trip trip) {
		super();
		this.officeId = officeId;
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.trip = trip;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Date getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(Date endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public Long getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(Long officePrice) {
		this.officePrice = officePrice;
	}

	public Date getStartContractDeadline() {
		return startContractDeadline;
	}

	public void setStartContractDeadline(Date startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}

//	public Trip getTrip() {
//		return trip;
//	}
//
//	public void setTrip(Trip trip) {
//		this.trip = trip;
//	}

	@Override
	public String toString() {
		return "BookingOffice [officeId=" + officeId + ", endContractDeadline=" + endContractDeadline + ", officeName="
				+ officeName + ", officePhone=" + officePhone + ", officePlace=" + officePlace + ", officePrice="
				+ officePrice + ", startContractDeadline=" + startContractDeadline + ", trip=" + trip + "]";
	}

	
	
}
