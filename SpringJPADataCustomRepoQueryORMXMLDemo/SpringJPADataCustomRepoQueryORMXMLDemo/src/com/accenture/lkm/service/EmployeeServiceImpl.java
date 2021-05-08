package com.accenture.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapper daoWrapper;

	@Override
	public List<EmployeeBean> getAllEmployeesSalaryRange(Double lowerRange, Double upperRange) {
		// TODO Auto-generated method stub
		return daoWrapper.getAllEmployeesSalaryRange(lowerRange, upperRange);
	}

	@Override
	public List<EmployeeBean> getAllEmployeesParam(Double salary) {
		// TODO Auto-generated method stub
		return daoWrapper.getAllEmployeesParam(salary);
	}

	@Override
	public List getEmployeesRole() {
		// TODO Auto-generated method stub
		return daoWrapper.getEmployeesRole();
	}

	@Override
	public List getStringFunctions() {
		// TODO Auto-generated method stub
		return daoWrapper.getStringFunctions();
	}

//	@Override
//	public List<EmployeeBean> getEmployeesForSalaryandRole(String role, Double salary) {
//		// TODO Auto-generated method stub
//		return getEmployeesForSalaryandRole(role, salary);
//	}
}
