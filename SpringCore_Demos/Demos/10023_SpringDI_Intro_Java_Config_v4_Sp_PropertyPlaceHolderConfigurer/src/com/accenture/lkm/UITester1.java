package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.lkm.resources.MyConfiguration1;

public class UITester1 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration1.class); // change to
	 	
		Employee emp= (Employee)ctx.getBean("employee");
		System.out.println(emp);
	}
}
//Tell about Annotations
//Tell about the ${} vs #{}