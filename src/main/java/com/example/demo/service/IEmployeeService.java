package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Employee;



public interface IEmployeeService {
	 
	 Optional<Employee> getEmployeeById(Long id) ;
	 void deleteEmployee(Long employeeId) ;
	 Employee addEmployee(Employee employee) ;
	 Employee updateEmployee(Employee employee) ;
	 
	 
	 
	 Page<Employee> findAll(Pageable pageable);
	 Page <Employee> findByEmployeeName(String employeeName, Pageable pageable);
	 Page <Employee> findByDepartment(String department, Pageable pageable);
	 Page <Employee> findByEmployeeEmail(String employeeEmail, Pageable pageable);
	  

}
