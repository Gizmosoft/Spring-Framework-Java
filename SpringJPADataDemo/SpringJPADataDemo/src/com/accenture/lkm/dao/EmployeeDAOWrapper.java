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

	public EmployeeBean addEmployee(EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		EmployeeEntity entity = employeeDAO.save(employeeEntity);
		EmployeeBean employeeBean2 = new EmployeeBean();
		BeanUtils.copyProperties(entity, employeeBean2);
		return employeeBean2;
	}

	public EmployeeBean getEmployeeDetails(int employeeId) {
		EmployeeEntity entity = employeeDAO.findOne(employeeId);
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

	public List<EmployeeBean> getAllEmployeeDetails() {
		List<EmployeeEntity> list = (List<EmployeeEntity>) employeeDAO.findAll();
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		for (EmployeeEntity entity : list) {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(entity, employeeBean);
			beans.add(employeeBean);
		}
		return beans;
	}

	public void deleteEmployee(int employeeId) throws Exception {
		EmployeeEntity entity = employeeDAO.findOne(employeeId);
		if (entity != null) {
			employeeDAO.delete(entity);
		} else {
			throw new Exception("Details does not exist");
		}
	}

	public EmployeeBean updateEmployee(EmployeeBean employeeBean) throws Exception {
		EmployeeEntity entity = employeeDAO.findOne(employeeBean.getId());
		EmployeeBean bean = null;
		if (entity != null) {
			entity.setRole(employeeBean.getRole());
			entity.setSalary(employeeBean.getSalary());
			EmployeeEntity entity2 = employeeDAO.save(entity);
			bean = new EmployeeBean();
			BeanUtils.copyProperties(entity2, bean);
		} else {
			throw new Exception("Details does not exist");
		}
		return bean;
	}

}
