package com.example.employee_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
    Page<Employee> findByNameContaining(String name, Pageable pageable);
    Page<Employee> findByPosition(String position, Pageable pageable);
}
