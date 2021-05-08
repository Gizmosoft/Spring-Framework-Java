package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {
	List<EmployeeBean> getAllEmployeesSalaryRange(Double lowerRange, Double upperRange);

	List<EmployeeBean> getAllEmployeesParam(Double salary);

	List getEmployeesRole();

	List getStringFunctions();

	// List<EmployeeBean> getEmployeesForSalaryandRole(String role, Double salary);
}
