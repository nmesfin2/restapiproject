package com.nat.employeerestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.employeerestapi.model.Employee;
import com.nat.employeerestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return employee2;
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(employeeRepository.findAll());
	}

}
