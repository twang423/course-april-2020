package com.bht.humanresource.controller;

import com.bht.humanresource.model.Department;
import com.bht.humanresource.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public void createDepartment(@RequestBody Department department) { service.createDepartment(department); }

    @PutMapping("/update")
    public void updateDepartment(@RequestParam(name = "id") Integer id,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "location", required = false) String location) {
        service.updateDepartment(id, name, location);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable int id) { service.deleteDepartment(id); };
}
