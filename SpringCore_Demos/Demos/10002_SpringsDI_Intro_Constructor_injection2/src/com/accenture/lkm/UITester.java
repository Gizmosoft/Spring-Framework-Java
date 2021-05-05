package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/resources/my_springbean1.xml");
		Employee employee = (Employee) applicationContext.getBean("emp");
		System.out.println("\n\n\nOutput is :");
		System.out.println(employee);
		
		Contact contact = (Contact) applicationContext.getBean("primaryContact");
		System.out.println(contact);
	}

}
// For constructor what ever access specifer you give it will always override
/// and make it as public, where it is Spring Security Manager.

// activity to perform and ask question..
// my_springbean will give error as our employee class is not having the default
// constructor to support the injection process
// later show with the my_springbean1.xml
