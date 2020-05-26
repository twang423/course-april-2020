package com.bht.humanresource.controller;

import com.bht.humanresource.model.Department;
import com.bht.humanresource.model.Employee;
import com.bht.humanresource.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/test")
    public String greetings() { return "Hello World"; }

    private EmployeeService service;

    public EmployeeService getService() {
        return service;
    }

    @Autowired
    public void setService(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public List<Employee> getEmployeeById(@PathVariable int id) { return service.getEmployeeById(id); }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() { return service.getAllEmployee(); }

    @PostMapping("/new")
    public void createEmployee(@RequestBody Employee employee) { service.createEmployee(employee); }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) { service.deleteEmployee(id); };
}
