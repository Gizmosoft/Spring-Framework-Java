package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.resources.MyConfiguration;

public class UITester {
	public static void main(String[] args) {
	
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(MyConfiguration.class); // change to MyConfiguration2  and taste
		Employee employee = (Employee)ctx.getBean("employee");
		System.out.println(employee);
		
		
		System.out.println("\n\n****Printing Details******");
		employee.display();
		
		
	}
}

// show usage of inject is same as that of autowired
// can be placed at field, setter and constructor level
// but unlike autowired (required= true/false), it is always a required dependency
