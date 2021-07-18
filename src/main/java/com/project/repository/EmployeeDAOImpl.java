package com.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Employee;

@Repository
public class EmployeeDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> getEmployee() {
		try(Session session = sessionFactory.openSession();){
			Query query = (Query) session.createQuery("from Employee");
			List<Employee> empList = query.getResultList();
			return empList;
		}
	}
	
	public Employee getEmployee(String id) {
		try(Session session = sessionFactory.openSession();){
			Employee emp = (Employee) session.get(Employee.class, Integer.parseInt(id));
			return emp;
		}
	}

	public void addEmployee(Employee employee) {
		try(Session session = sessionFactory.openSession();){
			Transaction tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();
		}
	}

	public void updateEmployee(Employee employee) {
		try(Session session = sessionFactory.openSession();){
			Transaction tx = session.beginTransaction();
			
			employee = (Employee) session.merge(employee);
			tx.commit();
		}
	}

	public Employee removeEmployee(String id) {
		try(Session session = sessionFactory.openSession();){
			Transaction tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,Integer.parseInt(id));
			session.remove(employee);
			tx.commit();
			return employee;
		}
		
	}
}