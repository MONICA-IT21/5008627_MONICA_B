package main.java.com.example;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends EmployeeRepository<Employee, Long> {
    // Derived query methods
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByName(String name);
}
