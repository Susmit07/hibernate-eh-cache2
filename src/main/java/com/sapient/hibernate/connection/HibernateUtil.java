package com.sapient.hibernate.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sapient.hibernate.bean.Employee;

/**
 * 
 * @author sircarsmac
 *
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory ;

	static {
		try {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
		    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		            .applySettings(configuration.getProperties());
		    sessionFactory = configuration.buildSessionFactory(builder.build());
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("SessionFactory creation failed." + e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
