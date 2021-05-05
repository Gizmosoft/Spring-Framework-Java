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

// Resource can be placed at the field level, 
//setter level but not at the constructor level 