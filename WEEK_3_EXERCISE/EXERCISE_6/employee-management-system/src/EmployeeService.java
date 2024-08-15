import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    public Page<Employee> searchEmployees(String name, String position, Pageable pageable) {
        if (!name.isEmpty() && !position.isEmpty()) {
            return employeeRepository.findByNameContaining(name, pageable);
        } else if (!name.isEmpty()) {
            return employeeRepository.findByNameContaining(name, pageable);
        } else if (!position.isEmpty()) {
            return employeeRepository.findByPosition(position, pageable);
        } else {
            return employeeRepository.findAll(pageable);
        }
    }
}
