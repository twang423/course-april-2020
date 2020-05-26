package com.bht.humanresource.helper;

import com.bht.humanresource.dao.DepartmentRepository;
import com.bht.humanresource.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentHelper {
    private DepartmentRepository repo;

    @Autowired
    public DepartmentHelper(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getDepartmentById(int id) {
        return repo.findById(id);
    }

    public List<Department> getAllDepartment() {
        return repo.findAllByIdNotNull();
    }
}
