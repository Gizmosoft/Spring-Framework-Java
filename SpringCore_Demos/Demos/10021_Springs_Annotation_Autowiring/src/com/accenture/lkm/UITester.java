package com.accenture.lkm;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		//1st Time
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
		
		applicationContext.close();	
	}
}
//1 Check ConfigurableApplicationContext, using this we can close the context.....
//

