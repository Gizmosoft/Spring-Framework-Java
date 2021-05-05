package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.resources.MyConfiguration2;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MyConfiguration2.class);
		
	
	}

}
 
//Only address instance will get created