package com.project.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfig {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String hibernateDialect;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateDDLAuto;
	
	@Value("${entityManager.packageToScan}")
	private String packageToScan;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate-dialect", hibernateDialect);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateDDLAuto);
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setPackagesToScan(packageToScan);
		return sessionFactory;
	}
}
