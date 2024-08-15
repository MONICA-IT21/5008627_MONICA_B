package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(name = "Employee.findByDepartmentId")
    List<Employee> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);

    @Query(name = "Employee.findByNameContaining")
    List<Employee> findEmployeesByNameContaining(@Param("name") String name);

    @Query(name = "Employee.findByPosition")
    List<Employee> findEmployeesByPosition(@Param("position") String position);
}
