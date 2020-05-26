package com.bht.humanresource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="empid")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="job")
    private String job;
    @Column(name="manager")
    private Integer manager;
    @Column(name="hiredate")
    private Date hireDate;
    @Column(name="salary")
    private double salary;
    @Column(name="deptid")
    private Integer departmentId;

    public Employee() {
    }

    public Employee(int id, String name, String job, int manager, Date hireDate, double salary, int departmentId) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
