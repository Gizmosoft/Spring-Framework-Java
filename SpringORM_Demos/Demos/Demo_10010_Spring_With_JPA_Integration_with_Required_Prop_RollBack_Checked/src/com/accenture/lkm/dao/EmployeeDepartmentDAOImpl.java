package com.accenture.lkm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.DepartmentBean;
import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.DepartmentEntity;
import com.accenture.lkm.entity.EmployeeEntity;
import com.accenture.lkm.exceptions.InvalidDummyException;
@Repository
public class EmployeeDepartmentDAOImpl implements EmployeeDepartmentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		
		EmployeeEntity employeeEntityBean =convertEmployeeBeanToEntity(employeeBean);
		try {
				entityManager.persist(employeeEntityBean);
				dummyCodeThrowingCheckedException();
			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}
		return employeeID;
	}
	

	
	public Integer addDepartment(DepartmentBean departmentBean)
			throws Exception {
		// TODO Auto-generated method stub
		Integer departmentCode = 0;
		
		DepartmentEntity departmentEntityBean =convertDepartmentBeanToEntity(departmentBean);
		try {
				entityManager.persist(departmentEntityBean);
				
			departmentCode = departmentEntityBean.getDepartmentCode();
		} catch (Exception exception) {
			throw exception;
		}
		return departmentCode;
	}
	
	
	public void dummyCodeThrowingCheckedException() throws InvalidDummyException{
		throw new InvalidDummyException();
	}
	
	public static EmployeeBean convertEmployeeEntityToBean(EmployeeEntity entity){
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static EmployeeEntity convertEmployeeBeanToEntity(EmployeeBean bean){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean,employeeEntityBean);
		return employeeEntityBean;
	}
	
	public static DepartmentBean convertDepartmentEntityToBean(DepartmentEntity entity){
		DepartmentBean departmentBean = new DepartmentBean();
		BeanUtils.copyProperties(entity, departmentBean);
		return departmentBean;
	}
	public static DepartmentEntity convertDepartmentBeanToEntity(DepartmentBean bean){
		DepartmentEntity departmentEntityBean = new DepartmentEntity();
		BeanUtils.copyProperties(bean,departmentEntityBean);
		return departmentEntityBean;
	}



	
	
}
