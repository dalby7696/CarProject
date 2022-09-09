package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.password.ValidPassword;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


@Entity

public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long employeeId;
	
	@NotBlank(message = "account is mandatory")
	@Column(length = 50)
	private String account;
	
	@NotBlank(message = "department is mandatory")
	@Column(length = 10)
	private String department;
	
	@Column(length = 50)
	private String employeeAddress;
	
	private Date employeeBirthdate;
	
	@Column(length = 50)
	private String employeeEmail;
	
	@NotBlank(message = "employeeName is mandatory")
	@Column(length = 50)
	private String employeeName;
	
	
	@NotBlank(message = "employeePhone is mandatory")
	@Column(length = 10)
	private String employeePhone;
	
	
	@NotBlank(message = "password is mandatory")
	@ValidPassword
	 
	@Column(length = 20)
	private String password;
	
	
	@NotBlank(message = "sex is mandatory")
	@Column(length = 1)
	private String sex;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long employeeId, String account, String department, String employeeAddress, Date employeeBirthdate,
			String employeeEmail, String employeeName, String employeePhone, String password, String sex) {
		super();
		this.employeeId = employeeId;
		this.account = account;
		this.department = department;
		this.employeeAddress = employeeAddress;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.password = password;
		this.sex = sex;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	@JsonSerialize(using=DateSerializer.class)
	public Date getEmployeeBirthdate() {
		return employeeBirthdate;
	}

	public void setEmployeeBirthdate(Date employeeBirthdate) {
		this.employeeBirthdate = employeeBirthdate;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	

}
