package com.accenture.lkm.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.lkm.Employee;

public class UITester {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean.xml");
		
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
	}

}
 