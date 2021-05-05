package com.accenture.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employeeBean);
	}

	@Override
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeDetails(id);
	}

	@Override
	public List<EmployeeBean> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeList();
	}

	@Override
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployeeDetails(employeeBean);
	}

	@Override
	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployeeDetails(id);
	}

}
