package com.accenture.lkm.service;

import com.accenture.lkm.business.bean.DepartmentBean;
import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeDepartmentService {

	Integer addEmployeeAndDepartment(EmployeeBean employeeBean,DepartmentBean departmentBean)	throws Exception;

}
