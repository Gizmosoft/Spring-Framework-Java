package com.accenture.lkm.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;

public class UITester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/cst-main-config.xml");
		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeServiceImpl");
		List<EmployeeBean> bean = null;
		// bean = employeeService.getAllEmployeesSalaryRange(30000.00, 40000.00);
//		bean = employeeService.getAllEmployeesParam(45000.00);
//		bean = employeeService.getEmployeesForSalaryandRole("Sr.Analyst", 40000.00);
//		for (EmployeeBean employeeBean : bean) {
//			System.out.println(employeeBean);
//		}
		/*
		 * System.out.println("Count \t Role "); List list =
		 * employeeService.getEmployeesRole(); for (Object obj : list) { Object[]
		 * objArray = (Object[]) obj; System.out.println(objArray[0] + ", " +
		 * objArray[1]); }
		 */
		List result = employeeService.getStringFunctions();
		for (Object obj : result) {
			Object[] objArray = (Object[]) obj;
			System.out.println(objArray[1] + " " + objArray[2] + " " + objArray[3] + " " + objArray[4]);
		}
	}

}
