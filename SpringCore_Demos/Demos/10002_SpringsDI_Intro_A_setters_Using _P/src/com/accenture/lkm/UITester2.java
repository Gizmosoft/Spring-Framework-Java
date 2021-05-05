package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester2 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean1.xml");
		Employee employee1 = (Employee) applicationContext.getBean("empObject");
		Employee employee2 = (Employee) applicationContext.getBean("empObject2");
		
		employee1.display();
		employee2.display();
		System.out.println(employee1);
		System.out.println(employee2);
	}

}
// but how to finally get rid f object creation ??
