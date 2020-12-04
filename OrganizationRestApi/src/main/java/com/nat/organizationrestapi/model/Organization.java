package com.nat.organizationrestapi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Organization_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	
	@Id
	private Long id;
	private String name;
	private String address;
	//private List<Department> departments = new ArrayList<>();
	//private List<Employee> employees = new ArrayList<>();
	
//	@OneToMany(mappedBy="organization", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	private Set<Department> departments = new HashSet<>();
	private String departments;

//	@OneToMany(mappedBy="organization", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	private Set<Employee> employees = new HashSet<>();
	private String employees;
}

