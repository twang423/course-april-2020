package com.bht.humanresource.helper;

import com.bht.humanresource.dao.EmployeeRepository;
import com.bht.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeHelper {
    private EmployeeRepository repo;

    @Autowired
    public EmployeeHelper(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> getEmployeeById(int id) { return repo.findById(id); }

    public List<Employee> getAllEmployee() { return repo.findAllByIdNotNull(); }

    public void createEmployee(Employee employee) { repo.save(employee); }

    public void deleteEmployee(int id) { repo.deleteById(id); }
}
