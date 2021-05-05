package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(	"com/accenture/lkm/resources/my_springbean1.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		System.out.println("\n\n\nOutput is :");
		employee.display();
		
 
	}

}
// For constructor what ever access specifier you give it will always override
/// and make it as public, where it is Spring Security Manager.

// activity to perform and ask question..
// my_springbean will give error as our employee class is not having the default
// constructor to support the injection process
// later show with the my_springbean1.xml
