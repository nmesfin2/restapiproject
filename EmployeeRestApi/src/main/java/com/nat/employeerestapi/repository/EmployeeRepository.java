package com.nat.employeerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.employeerestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//	List<Employee> findByCategory(String catName);
//	// select * from product where price > pricevalue
//	List<Employee> findByPriceGreaterThan(float priceValue );
//	List<Employee> findByCategoryAndPriceLessThan(String category,float price);
//
//	//("a%")
//	List<Employee> findByProductNameLike(String productName);
}
