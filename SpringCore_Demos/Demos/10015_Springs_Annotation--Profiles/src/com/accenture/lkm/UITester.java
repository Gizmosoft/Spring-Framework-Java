package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {
		//System.setProperty("spring.profiles.active", "myProfile");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
	}

}

 