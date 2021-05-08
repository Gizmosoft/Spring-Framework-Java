package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.EmployeeEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = EmployeeEntity.class)
@Transactional(value = "txManager")
public interface EmployeeDAO {

	@Query("select k from EmployeeEntity k where k.salary >= ?1 and k.salary <= ?2")
	List<EmployeeEntity> getAllEmployeesBySalary(Double lowerRange, Double upperRange);

	@Query("select k from EmployeeEntity k where k.salary >= :sal")
	List<EmployeeEntity> getAllEmployeesBySalaryNamedParameter(@Param("sal") Double salary);

	@Query("Select count(k), k.role from EmployeeEntity k group by k.role")
	List getRolesAndCountOfEmployeesInEachRole();

	@Query(name = "EMP.query1_getAllEmployeesStringFunctions")
	List getEmployeeNameStringFunctions();

	/*
	 * @Query("select k from EmployeeEntity k where k.role = ?1 and k.salary >= :sal"
	 * ) List<EmployeeEntity> getEmployeesRoleAndSalary(String role, @Param("sal")
	 * Double salary);
	 */

}
