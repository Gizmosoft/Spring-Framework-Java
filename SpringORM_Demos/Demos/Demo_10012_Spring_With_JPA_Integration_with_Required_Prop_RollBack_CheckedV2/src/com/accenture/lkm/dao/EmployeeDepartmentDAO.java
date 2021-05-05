package com.accenture.lkm.dao;

import com.accenture.lkm.business.bean.DepartmentBean;
import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeDepartmentDAO {

	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	Integer addDepartment(DepartmentBean departmentBean) throws Exception;

}