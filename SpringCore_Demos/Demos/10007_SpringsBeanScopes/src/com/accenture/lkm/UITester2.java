package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester2 {

	public static void main(String[] args) {

		// 1st Time
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/my_springbean_proto.xml");
		Employee employee1 = (Employee) applicationContext.getBean("empObject");

		System.out.println("\nPlease check the HashCodes");
		System.out.println("=========================");
		System.out.println(employee1);
		System.out.println(employee1.getAddress());

		// 2nd Time
		Employee employee2 = (Employee) applicationContext.getBean("empObject1");
		System.out.println(employee2);
		System.out.println(employee2.getAddress());
 

	}

}
