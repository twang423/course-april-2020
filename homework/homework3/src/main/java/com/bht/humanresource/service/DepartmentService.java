package com.bht.humanresource.service;

import com.bht.humanresource.helper.DepartmentHelper;
import com.bht.humanresource.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentHelper helper;

    public List<Department> getDepartmentById(int id) {
        return helper.getDepartmentById(id);
    }

    public List<Department> getAllDepartment() {
        return helper.getAllDepartment();
    }

    public void createDepartment(Department department) { helper.createDepartment(department); }
}
