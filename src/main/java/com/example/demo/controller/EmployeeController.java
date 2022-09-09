package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	IEmployeeService iEmployeeService;
	
	 
	public EmployeeController(IEmployeeService iEmployeeService) {
		super();
		this.iEmployeeService = iEmployeeService;
	}







	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		Optional<Employee> Employee = iEmployeeService.getEmployeeById(id);
		
		if(Employee.isPresent()) {
			return new ResponseEntity<>(Employee.get(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 
	
	
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody  @Valid  Employee employee){
		try {
			return new ResponseEntity<Employee>(iEmployeeService.addEmployee(employee),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		try {
			return new ResponseEntity<Employee>(iEmployeeService.updateEmployee(employee),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
		try {
			iEmployeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	  
	@GetMapping("/employees")
	  public ResponseEntity<Map<String, Object>> getAllployees(
	        @RequestParam(required = false) String email,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String department,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
	    try {
	      List<Employee> employees = new ArrayList<Employee>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Employee> pageEmployees;

	      
	      if (email == null && name==null && department==null) {
		        pageEmployees = iEmployeeService.findAll(paging);
		      }
		      else if (email == null && name!=null && department==null) {
		    	  pageEmployees = iEmployeeService.findByEmployeeName(name, paging);
		      }
		      else if (email == null && name==null && department!=null) {
		    	  pageEmployees = iEmployeeService.findByDepartment(department, paging);
		      }
		      
		    else {
		  	        pageEmployees = iEmployeeService.findByEmployeeEmail(email, paging);
			}
	      
	      employees = pageEmployees.getContent();//to retrieve the List of items in the page.
	      Map<String, Object> response = new HashMap<>();
	      response.put("employees", employees);
	      response.put("currentPage", pageEmployees.getNumber());//for current Page.
	      response.put("totalItems", pageEmployees.getTotalElements());//for total items stored in database.
	      response.put("totalPages", pageEmployees.getTotalPages());//for number of total pages.
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  
	  

}
