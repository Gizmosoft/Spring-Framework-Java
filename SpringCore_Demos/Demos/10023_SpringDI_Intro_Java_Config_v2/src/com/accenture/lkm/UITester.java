package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.lkm.resources.MyConfiguration;

public class UITester {
	public static void main(String[] args) {
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class); // change to MyConfiguration2  and taste
		Employee employee = (Employee) ctx.getBean("createEmployee");
		employee.display();
		
	}
}
