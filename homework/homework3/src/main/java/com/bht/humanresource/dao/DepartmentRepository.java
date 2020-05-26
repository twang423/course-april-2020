package com.bht.humanresource.dao;

import com.bht.humanresource.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@EnableJpaRepositories
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    List<Department> findById(int id);
    List<Department> findAllByIdNotNull();

    @Modifying
    @Transactional
    @Query("update Department d set d.name =?2 where d.id = ?1")
    void setDepartmentName(Integer id, String name);

    @Modifying
    @Transactional
    @Query("update Department d set d.location = ?2 where d.id = ?1")
    void setDepartmentLocation(Integer id, String location);
}


