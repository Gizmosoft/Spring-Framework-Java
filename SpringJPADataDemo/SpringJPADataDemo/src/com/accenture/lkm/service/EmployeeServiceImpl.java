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
	public EmployeeBean addEmployee(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
		return daoWrapper.addEmployee(employeeBean);
	}

	@Override
	public EmployeeBean getEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		return daoWrapper.getEmployeeDetails(employeeId);
	}

	@Override
	public List<EmployeeBean> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return daoWrapper.getAllEmployeeDetails();
	}

	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		daoWrapper.deleteEmployee(employeeId);

	}

	@Override
	public EmployeeBean updateEmployee(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		return daoWrapper.updateEmployee(employeeBean);
	}

}
