package com.bht.humanresource.service;

import com.bht.humanresource.helper.EmployeeHelper;
import com.bht.humanresource.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeHelper helper;

    public List<Employee> getEmployeeById(int id) { return helper.getEmployeeById(id); }

    public List<Employee> getAllEmployee() { return helper.getAllEmployee(); }

    public void createEmployee(Employee employee) { helper.createEmployee(employee); }

    public void deleteEmployee(int id) { helper.deleteEmployee(id); }
}
