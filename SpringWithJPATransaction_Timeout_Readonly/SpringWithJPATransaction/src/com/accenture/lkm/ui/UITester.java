package com.accenture.lkm.ui;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;

public class UITester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/accenture/lkm/resources/cst-main-config.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
		EmployeeBean bean = new EmployeeBean();
		bean.setName("Amutha");
		bean.setRole("Associate");
		bean.setSalary(25000.00);
		bean.setInsertTime(new Date());
		try {
			int id = employeeService.addEmployee(bean);
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * try { bean = employeeService.getEmployeeDetails(5); System.out.println(bean);
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		/*
		 * bean.setId(3); bean.setRole("Associate Manager"); bean.setSalary(130000.00);
		 * try { EmployeeBean result = employeeService.updateEmployeeDetails(bean);
		 * System.out.println(result); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
//		try {
//			bean = employeeService.deleteEmployeeDetails(5);
//			System.out.println(bean);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}