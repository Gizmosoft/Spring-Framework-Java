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
		EmployeeBean bean = new EmployeeBean();

		/*
		 * // Code to add employee details bean.setName("Janet");
		 * bean.setRole("Associate Manager"); bean.setInsertTime(new Date());
		 * bean.setSalary(100000.00); try { int eid = employeeService.addEmployee(bean);
		 * System.out.println("Inserted " + eid); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * To fetch employee details try { bean = employeeService.getEmployeeDetails(1);
		 * System.out.println(bean); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		/*
		 * to fetch all details List<EmployeeBean> result; try { result =
		 * employeeService.getEmployeeList(); for (EmployeeBean employeeBean : result) {
		 * System.out.println(employeeBean); } } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		/*
		 * to update EmployeeBean employeeBean = new EmployeeBean();
		 * employeeBean.setId(1); employeeBean.setRole("Sr.Analyst");
		 * employeeBean.setSalary(35000.00); try { bean =
		 * employeeService.updateEmployeeDetails(employeeBean);
		 * System.out.println(bean); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		try {
			bean = employeeService.deleteEmployeeDetails(4);
			System.out.println(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
