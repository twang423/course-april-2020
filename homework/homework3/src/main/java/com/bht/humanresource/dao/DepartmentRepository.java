package com.bht.humanresource.dao;

import com.bht.humanresource.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findById(int id);
    List<Department> findAllByIdNotNull();
}


