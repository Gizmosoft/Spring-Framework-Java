package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/my_springbean1.xml");
		Contact primaryContact = (Contact) applicationContext.getBean("primaryContact");
		System.out.println(primaryContact);
 
	}

}
 