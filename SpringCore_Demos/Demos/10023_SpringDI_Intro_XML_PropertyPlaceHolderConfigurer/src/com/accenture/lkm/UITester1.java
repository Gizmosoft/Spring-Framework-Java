package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester1 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/my_springbean.xml");
		Employee emp= (Employee)ctx.getBean("employee");
		System.out.println(emp);
	}
}
//Tell about Annotations
//Tell about the ${} vs #{}