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

    public void createDepartment(Department department) { repo.save(department); }

    public void updateDepartment(Integer id, String name, String location) {
        if (name != null)
            repo.setDepartmentName(id, name);
        if (location != null)
            repo.setDepartmentLocation(id, location);
    }

    public void deleteDepartment(int id) { repo.deleteById(id); }
}
