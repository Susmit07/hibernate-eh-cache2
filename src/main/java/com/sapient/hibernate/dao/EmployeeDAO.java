package com.sapient.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sapient.hibernate.bean.Employee;
import com.sapient.hibernate.connection.HibernateUtil;

public class EmployeeDAO {



	public void insertEmployee(Employee employee) {

		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(employee);
			session.getTransaction().commit();
		}catch(Exception e) {
			if(session.getTransaction() != null) session.getTransaction().rollback();
			System.out.println("Exception while persisting record to DB: "+e);
		}finally {
			try {
				if (session != null) {
					session.close();

				}
				HibernateUtil.shutdown();
			}catch (Exception e) {
				System.out.println("Exception while closing the session: "+e);			}
		}
	}

	public void readEmployeeDetailsUsingCache() {

		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Employee employee = (Employee) session.get(Employee.class, new Long(1));
			System.out.println(employee.toString());
			// Reading the same details using EH Cache
			Employee employeeFromCache = (Employee) session.get(Employee.class, new Long(1));
			System.out.println(employeeFromCache.toString());
		}catch(Exception e) {
			System.out.println("Exception while persisting record to DB: "+e);
		}finally {
			try {
				if (session != null) {
					session.close();
				}
				HibernateUtil.shutdown();
			}catch (Exception e) {
				System.out.println("Exception while closing the session: "+e);			}
		}
	}
}
