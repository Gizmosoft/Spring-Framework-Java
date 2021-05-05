package com.accenture.lkm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/my_springbean.xml");
		OperatorsBean operatorsBean = (OperatorsBean) applicationContext.getBean("operatorBean");
		System.out.println(operatorsBean);
		operatorsBean.testElvisTernary();
	}

}
// EL Operators and SPEL
