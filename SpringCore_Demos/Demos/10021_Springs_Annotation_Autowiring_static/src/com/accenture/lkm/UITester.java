package com.accenture.lkm;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		//1st Time
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		
		employee.display();
		
		applicationContext.close();
		
	}

}
// @autowire and @value doesnot works with the static variables
