package com.nat.departmentrestapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Department_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	private Long id;
	
//	@Column(name="organization_id")
//	private Long organizationId;
	private String name;
	//private List<Employee> employees;

	//@OneToMany(mappedBy="department", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	private Set<Employee> employees = new HashSet<>();
	private String employees;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="organization_id")
//	private Organization organization;
	private String organization;
}
