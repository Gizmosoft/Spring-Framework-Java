package com.accenture.lkm.db.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:com/accenture/lkm/resources/cst_conn.properties")
@EnableTransactionManagement // equivalent to <tx:annotation-driven>
public class SpringDBConfig {
	
	// reading value from properties file and giving to the datasource
	@Value("${cst_db_driver}")
	private String driverName;
	
	@Value("${cst_db_url}")
	private String url;
	
	@Value("${cst_user}")
	private String userName;
	
	@Value("${cst_password}")
	private String password;
	//To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
			return new PropertySourcesPlaceholderConfigurer();
	}

	//Data source can have any name
	@Bean(name = "cst_DataSource")
	public DriverManagerDataSource getDataSource() {
		System.out.println(driverName);
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}

	public HibernateJpaVendorAdapter getVendorAdaptor(){
		HibernateJpaVendorAdapter adapter = new  HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}


	@Bean(name = "cst_entityManagerFactory") 
	public LocalContainerEntityManagerFactoryBean getSessionFactory(DriverManagerDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factoryBuilder = new LocalContainerEntityManagerFactoryBean();
		factoryBuilder.setDataSource(dataSource);
		factoryBuilder.setJpaVendorAdapter(getVendorAdaptor());
		factoryBuilder.setPackagesToScan("com.accenture.lkm.entity");
		return factoryBuilder;
	}
	@Bean(name = "txManager")
	public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		return transactionManager;
	}
	
	
}
/*
 * Equivalent XML
 *<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans     
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">

    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="location">
			<value>classpath:com/accenture/lkm/resources/cst_conn.properties</value> <!-- class path is requried when runing from web app -->
		</property>
	</bean>
    
    
    <bean id="cst_DataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource" >
        <property name="driverClassName" value="${cst_db_driver}" />
        <property name="url" value="${cst_db_url}" />
        <property name="username" value="${cst_user}" />
        <property name="password" value="${cst_password}" />
    </bean>
 
 
	<!-- entity manager factory -->
    <bean id="cst_entityManagerFactory"	class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="cst_DataSource" />
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
				<property name="showSql" value="true" />
				<property name="generateDdl" value="true" />
				<property name="databasePlatform" value="org.hibernate.dialect.MySQLDialect" />
			</bean>
		</property>
		<property name="packagesToScan" value="com.accenture.lkm.entity"></property>
	</bean>

    <tx:annotation-driven transaction-manager="txManager"/>	
    <bean id="txManager" class="org.springframework.orm.jpa.JpaTransactionManager"> <!--  custom transaction Manager -->
		<property name="entityManagerFactory" ref="cst_entityManagerFactory" />
	</bean>
    
</beans>
 * 
 * 
 * */
