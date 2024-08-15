package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d.id AS id, d.name AS name, d.createdDate AS createdDate FROM Department d WHERE d.name = :name")
    DepartmentProjection findDepartmentProjectionByName(String name);
}
