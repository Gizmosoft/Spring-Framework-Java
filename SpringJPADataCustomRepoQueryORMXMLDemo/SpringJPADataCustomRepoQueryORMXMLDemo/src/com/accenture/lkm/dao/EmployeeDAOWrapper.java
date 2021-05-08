package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<EmployeeBean> getAllEmployeesSalaryRange(Double lowerRange, Double upperRange) {
		List<EmployeeEntity> entities = employeeDAO.getAllEmployeesBySalary(lowerRange, upperRange);
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		for (EmployeeEntity entity : entities) {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(entity, employeeBean);
			list.add(employeeBean);
		}
		return list;

	}

	public List<EmployeeBean> getAllEmployeesParam(Double salary) {
		List<EmployeeEntity> entities = employeeDAO.getAllEmployeesBySalaryNamedParameter(salary);
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		for (EmployeeEntity entity : entities) {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(entity, employeeBean);
			list.add(employeeBean);
		}
		return list;
	}

	public List getEmployeesRole() {
		List result = employeeDAO.getRolesAndCountOfEmployeesInEachRole();
		return result;
	}

	public List getStringFunctions() {
		List result = employeeDAO.getEmployeeNameStringFunctions();
		return result;
	}

	/*
	 * public List<EmployeeBean> getEmployeesForSalaryandRole(String role, Double
	 * salary) { List<EmployeeEntity> entities =
	 * employeeDAO.getEmployeesRoleAndSalary(role, salary); List<EmployeeBean> list
	 * = new ArrayList<EmployeeBean>(); for (EmployeeEntity entity : entities) {
	 * EmployeeBean employeeBean = new EmployeeBean();
	 * BeanUtils.copyProperties(entity, employeeBean); list.add(employeeBean); }
	 * return list; }
	 */

}
