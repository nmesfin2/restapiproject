package com.nat.departmentrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.departmentrestapi.model.Department;
import com.nat.departmentrestapi.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		Department department2 = null;
		try {
			department = departmentRepository.save(department);
			return department;
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Department> getDepartmentById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public void deleteDepartment(long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findAll());
	}

}
