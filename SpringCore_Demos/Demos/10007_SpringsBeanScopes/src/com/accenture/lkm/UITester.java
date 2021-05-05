package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		//1st Time
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean_a1.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");


		System.out.println("Please check the HashCodes");
		System.out.println("=========================");
		System.out.println(employee);
		
		//2nd Time
		Employee employee2 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee2);
		
		//3rd Time
		Employee employee3 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee3);
		
		//4th Time
		Employee employee4 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee4);
		
		//5th Time
		Employee employee5 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee5);
		
		//6th Time
		Employee employee6 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee6);
		
	}

}
 