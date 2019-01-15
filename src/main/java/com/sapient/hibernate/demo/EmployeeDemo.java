package com.sapient.hibernate.demo;

import java.util.Date;

import com.sapient.hibernate.bean.Employee;
import com.sapient.hibernate.dao.EmployeeDAO;

public class EmployeeDemo {

	public static void main(String[] args) {

		EmployeeDAO empDao = new EmployeeDAO(); 
		Employee emp = new Employee();
		emp.setName("Akash");
		emp.setDepartment("Security");
		emp.setJoinedOn(new Date());
		emp.setSalary(10000L);
		// empDao.insertEmployee(emp);
		empDao.readEmployeeDetailsUsingCache();
	}
}
