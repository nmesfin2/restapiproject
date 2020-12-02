package com.nat.employeerestapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nat.employeerestapi.exception.ResourceNotFoundException;
import com.nat.employeerestapi.model.Employee;
import com.nat.employeerestapi.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees().get();
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployeeById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Employee employee2 = employeeService.AddEmployee(employee);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(employee2.getId());
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(employee2);
	}
	
	@DeleteMapping("/{employeeId}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable long employeeId) throws ResourceNotFoundException { 
		Employee employee = employeeService.getEmployeeById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		
		employeeService.deleteEmployee(employeeId);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
}
