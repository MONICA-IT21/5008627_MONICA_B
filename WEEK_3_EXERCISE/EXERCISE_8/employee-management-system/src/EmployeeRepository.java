package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.employeemanagement.dto.EmployeeDto(e.id, e.name, e.position, e.createdDate) FROM Employee e WHERE e.department.id = :departmentId")
    Page<EmployeeDto> findEmployeeDtosByDepartmentId(Long departmentId, Pageable pageable);

    @Query("SELECT new com.example.employeemanagement.dto.EmployeeDto(e.id, e.name, e.position, e.createdDate) FROM Employee e WHERE e.name LIKE %:name%")
    Page<EmployeeDto> findEmployeeDtosByNameContaining(String name, Pageable pageable);
}
