package com.example.demo.serviceImpl;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		 
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		if(getEmployeeById(employeeId).isPresent()) 
		{
			employeeRepository.delete(getEmployeeById(employeeId).get());
		}	
	}
	@Transactional
	@Override
	public Employee addEmployee(Employee employee) {
		 
		return employeeRepository.save(employee);
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}



	@Override
	public Page<Employee> findByEmployeeName(String employeeName, Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmployeeName(employeeName, pageable);
	}

	@Override
	public Page<Employee> findByDepartment(String department, Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartment(department, pageable);
	}

	@Override
	public Page<Employee> findByEmployeeEmail(String employeeEmail, Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmployeeEmail(employeeEmail, pageable);
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(pageable);
	}

	 

}
