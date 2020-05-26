package com.bht.humanresource.controller;

import com.bht.humanresource.model.Department;
import com.bht.humanresource.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @GetMapping("/test")
    public String greetings() {
        return "Hello World";
    }

    private DepartmentService service;

    public DepartmentService getService() { return service; }

    @Autowired
    public void setService(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public List<Department> getDepartmentById(@PathVariable int id) { return service.getDepartmentById(id); }

    @GetMapping("/get/all")
    public List<Department> getAllDepartment() { return service.getAllDepartment(); }
}
