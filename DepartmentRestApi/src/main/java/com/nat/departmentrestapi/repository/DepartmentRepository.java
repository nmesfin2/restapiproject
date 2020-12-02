package com.nat.departmentrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.departmentrestapi.model.Department;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
