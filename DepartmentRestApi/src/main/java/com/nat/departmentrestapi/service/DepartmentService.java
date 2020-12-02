package com.nat.departmentrestapi.service;

import java.util.Optional;

import com.nat.departmentrestapi.model.Department;

public interface DepartmentService {
	public Department addDepartment(Department department);
	public Optional<Department> getDepartmentById(long id);
	public void deleteDepartment(long id);
	public Optional<java.util.List<Department>> getDepartments();
	
}
