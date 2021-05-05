package com.accenture.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.DepartmentBean;
import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDepartmentDAO;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
	@Autowired
	private EmployeeDepartmentDAO employeeDepartmentDAO;
	@Transactional(value = "txManager")
	public Integer addEmployeeAndDepartment(EmployeeBean employeeBean,DepartmentBean departmentBean) throws Exception {
		
		int result = 0;
		try{
		int deptId=employeeDepartmentDAO.addDepartment(departmentBean);
						employeeBean.setDepartmentCode(deptId);
		result = deptId+employeeDepartmentDAO.addEmployee(employeeBean);
		
		}catch(Exception e){
			throw e;
		}
		return result;
	}
}
// default propagation is Required @Transactional(value = "txManager",propagation=Propagation.REQUIRED)
// Physical transaction and logical transaction share the same transactional scope