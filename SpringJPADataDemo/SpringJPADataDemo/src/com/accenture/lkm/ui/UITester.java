package com.accenture.lkm.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;

public class UITester {

	public static void main(String[] args) {
		EmployeeService employeeService = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/cst-main-config.xml");
		employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
		EmployeeBean employeeBean = new EmployeeBean();
		/*
		 * employeeBean.setName("Janet"); employeeBean.setInsertTime(new Date());
		 * employeeBean.setRole("Analyst"); employeeBean.setSalary(25000.00);
		 * EmployeeBean bean = employeeService.addEmployee(employeeBean);
		 * System.out.println(bean);
		 */
		/*
		 * employeeBean = employeeService.getEmployeeDetails(7);
		 * System.out.println(employeeBean);
		 */
//		try {
//			employeeService.deleteEmployee(7);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<EmployeeBean> result = employeeService.getAllEmployeeDetails();
//		for (EmployeeBean employee : result) {
//			System.out.println(employee);
//		}
		employeeBean.setId(6);
		employeeBean.setRole("Analyst");
		employeeBean.setSalary(30000.00);
		try {
			EmployeeBean employeeBean2 = employeeService.updateEmployee(employeeBean);
			System.out.println(employeeBean2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
