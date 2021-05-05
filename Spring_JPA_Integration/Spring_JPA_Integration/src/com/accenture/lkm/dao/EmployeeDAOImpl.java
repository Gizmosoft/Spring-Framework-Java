package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;

@Repository
@Transactional(value = "txManager")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		Integer employeeId;
		EntityManager entityManager = null;
		entityManager = entityManagerFactory.createEntityManager();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(employeeEntity);
			entityManager.getTransaction().commit();
			employeeId = employeeEntity.getId();
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return employeeId;
	}

	@Override
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean employeeBean = null;
		EntityManager entityManager = null;
		entityManager = entityManagerFactory.createEntityManager();
		try {
			EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id);
			if (employeeEntity != null) {
				employeeBean = new EmployeeBean();
				BeanUtils.copyProperties(employeeEntity, employeeBean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employeeBean;
	}

	@Override
	public List<EmployeeBean> getEmployeeList() throws Exception {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			List<EmployeeEntity> entityList = entityManager.createQuery("from EmployeeEntity").getResultList();
			for (EmployeeEntity employeeEntity : entityList) {
				EmployeeBean bean = new EmployeeBean();
				BeanUtils.copyProperties(employeeEntity, bean);
				employeeList.add(bean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employeeList;
	}

	@Override
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		EmployeeBean bean = null;
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employeeBean.getId());
			if (employeeEntity != null) {
				entityManager.getTransaction().begin();
				employeeEntity.setRole(employeeBean.getRole());
				employeeEntity.setSalary(employeeBean.getSalary());
				entityManager.merge(employeeEntity);
				entityManager.getTransaction().commit();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return getEmployeeDetails(employeeBean.getId());
	}

	@Override
	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		// TODO Auto-generated method stub
		EmployeeBean bean = null;
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id);
			if (employeeEntity != null) {
				entityManager.getTransaction().begin();
				entityManager.remove(employeeEntity);
				entityManager.getTransaction().commit();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return getEmployeeDetails(id);
	}

}
