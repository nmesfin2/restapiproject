package com.nat.employeerestapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name = "Employee_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
//	@Column(name="organization_id")
//	private long organizationId;
	
//	@Column(name="department_id")
//	private long departmentId;
	private String name;
	private int age;
	private String position;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="department_id")
	private String department;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="organization_id")
	private String organization;
}
