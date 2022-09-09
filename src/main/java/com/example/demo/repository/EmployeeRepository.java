package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	//@Query("SELECT p FROM Employee p WHERE p.employeeName = :employeeName")
	//Employee findEmployeeByNameParam(@Param("employeeName") String employeeName);
	
	Page<Employee> findAll(Pageable pageable);
	Page <Employee> findByEmployeeName(String employeeName, Pageable pageable);
	Page <Employee> findByDepartment(String department, Pageable pageable);
	Page <Employee> findByEmployeeEmail(String employeeEmail, Pageable pageable);
}
