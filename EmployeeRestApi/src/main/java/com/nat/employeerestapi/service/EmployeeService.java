package com.nat.employeerestapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nat.employeerestapi.model.Employee;


public interface EmployeeService {
	public Employee AddEmployee(Employee employee);
	public Optional<Employee> getEmployeeById(long id);
	public void deleteEmployee(long id);
	public Optional<java.util.List<Employee>> getEmployees();
	//public Optional<java.util.List<Product>> getProductsByCategory(String catName);
}
