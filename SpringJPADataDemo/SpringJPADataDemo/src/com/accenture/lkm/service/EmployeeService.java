package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean addEmployee(EmployeeBean employeeBean);

	public EmployeeBean getEmployeeDetails(int employeeId);

	public List<EmployeeBean> getAllEmployeeDetails();

	public void deleteEmployee(int employeeId) throws Exception;

	public EmployeeBean updateEmployee(EmployeeBean employeeBean) throws Exception;
}
