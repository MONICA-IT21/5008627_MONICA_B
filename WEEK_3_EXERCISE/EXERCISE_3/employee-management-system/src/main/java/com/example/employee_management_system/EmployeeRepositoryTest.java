package com.example.employeemanagement;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testEmployeeRepository() {
        // Create and save a department
        Department department = new Department();
        department.setName("Engineering");
        department = departmentRepository.save(department);

        // Create and save employees
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setPosition("Developer");
        employee1.setDepartmentId(department.getId());
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setPosition("Manager");
        employee2.setDepartmentId(department.getId());
        employeeRepository.save(employee2);

        // Retrieve employees by departmentId
        List<Employee> employees = employeeRepository.findByDepartmentId(department.getId());
        assertEquals(2, employees.size());

        // Retrieve employees by name
        employees = employeeRepository.findByName("John Doe");
        assertEquals(1, employees.size());
        assertEquals("John Doe", employees.get(0).getName());
    }
}
