package com.accenture.lkm.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.lkm.Address;
import com.accenture.lkm.Employee;

@Configuration
public class MyConfiguration {
	
	@Bean
	public Employee createEmployee(Address address){
		Employee  employee = new Employee(address);
		return  employee;
	}

	@Bean(name="address")
	public Address createAddress(){
		return new Address();
	}
}
// if Bean name is not given then the bean is created by the name of the method