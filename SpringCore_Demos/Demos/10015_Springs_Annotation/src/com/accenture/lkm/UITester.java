package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
	}

}

// @value annotation doesn't work with the getter methods
// these annotations are used for configuration purpose, in a layered
// architecture
