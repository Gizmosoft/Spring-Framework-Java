package com.accenture.lkm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;

@Repository
//@Transactional(value = "txManager")
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = "txManager", timeout = 3)
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		Integer employeeId = null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		try {
			BeanUtils.copyProperties(employeeBean, employeeEntity);
			entityManager.persist(employeeEntity);
			employeeId = employeeEntity.getId();
		} catch (Exception exception) {
			throw exception;
		}
		return employeeId;

	}

	@Override
	@Transactional(value = "txManager", readOnly = true)
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean employeeBean = new EmployeeBean();
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id);
		try {
			if (employeeEntity != null) {
				BeanUtils.copyProperties(employeeEntity, employeeBean);
			}
		} catch (Exception e) {
			throw e;
		}
		return employeeBean;
	}

	@Override
	@Transactional(value = "txManager")
	public List<EmployeeBean> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(value = "txManager")
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeBean.getId());
		if (employeeEntity != null) {
			employeeEntity.setRole(employeeBean.getRole());
			employeeEntity.setSalary(employeeBean.getSalary());
			entityManager.merge(employeeEntity);
		}
		return getEmployeeDetails(employeeBean.getId());
	}

	@Override
	@Transactional(value = "txManager")
	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		EmployeeBean bean = null;
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id);
		try {
			if (employeeEntity != null) {
				bean = new EmployeeBean();
				BeanUtils.copyProperties(employeeEntity, bean);
				entityManager.remove(employeeEntity);
			}
		} catch (Exception e) {
			throw e;
		}
		return bean;
	}

}
