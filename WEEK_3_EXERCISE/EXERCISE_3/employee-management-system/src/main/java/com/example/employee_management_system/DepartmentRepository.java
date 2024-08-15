package main.java.com.example.employee_management_system;

import com.example.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends EmployeeRepository<Department, Long> {
    Department findByName(String name);
}
