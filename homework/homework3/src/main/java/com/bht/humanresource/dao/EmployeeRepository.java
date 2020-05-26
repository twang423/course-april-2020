package com.bht.humanresource.dao;

import com.bht.humanresource.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findById(int id);
    List<Employee> findAllByIdNotNull();
}

