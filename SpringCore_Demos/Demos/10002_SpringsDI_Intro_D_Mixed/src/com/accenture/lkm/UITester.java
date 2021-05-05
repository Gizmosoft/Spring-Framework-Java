package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		System.out.println("\n\nOutput is");
		System.out.println("==============");
		employee.display();
		
		
		
	}

}
 