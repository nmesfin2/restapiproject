package com.nat.departmentrestapi.controller;

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

import com.nat.departmentrestapi.exception.ResourceNotFoundException;
import com.nat.departmentrestapi.model.Department;
import com.nat.departmentrestapi.service.DepartmentService;
import com.nat.departmentrestapi.model.Department;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping
	public List<Department> getDepartments() {
		return departmentService.getDepartments().get();
	}
	
	@GetMapping("/{departmentId}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") long departmentId) throws ResourceNotFoundException {
		Department department = departmentService.getDepartmentById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		return ResponseEntity.ok().body(department);
	}
	
	@PostMapping
	public ResponseEntity<?> addDepartment(@RequestBody Department department,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Department department2 = departmentService.addDepartment(department);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(department2.getId());
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(department2);
	}
	
	@DeleteMapping("/{departmentId}")
	public Map<String, Boolean> deleteDepartmentById(@PathVariable long departmentId) throws ResourceNotFoundException { 
		Department department = departmentService.getDepartmentById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department not found"));
		
		departmentService.deleteDepartment(departmentId);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
}
