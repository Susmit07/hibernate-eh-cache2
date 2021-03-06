package com.sapient.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="EMPLOYEES")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Employee implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="EMP_ID")
    private Long empId;
 
    private String name;
 
    private String department;
 
    private Long salary;
 
    @Column(name="JOINED_ON")
    private Date joinedOn;
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDepartment() {
        return department;
    }
 
    public void setDepartment(String department) {
        this.department = department;
    }
 
    public Long getSalary() {
        return salary;
    }
 
    public void setSalary(Long salary) {
        this.salary = salary;
    }
 
    public Date getJoinedOn() {
        return joinedOn;
    }
 
    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }
 
    @Override
    public String toString() {
        return this.empId+" | "+this.name+" | "+this.department+" | "+this.salary+" | "+this.joinedOn;
    }
}