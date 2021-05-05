package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester3 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/accenture/resources/my_springbean_with_Lazy.xml");
		
		Employee employee = (Employee) applicationContext.getBean("empObject");
		//employee.display();
	}

}
