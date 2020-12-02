package com.nat.employeerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EmployeeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
	
		//EmployeeService empService = context.getBean(EmployeeService.class);
		
		//Employee emp = new Employee(1, "emplyeename", 18, "manager", "HR", "org");
	}

}
