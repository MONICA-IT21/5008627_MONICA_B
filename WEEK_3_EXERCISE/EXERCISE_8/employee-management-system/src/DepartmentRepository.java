

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.dto.DepartmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.example.employeemanagement.dto.DepartmentDto(d.id, d.name, d.createdDate) FROM Department d WHERE d.name = :name")
    DepartmentDto findDepartmentDtoByName(String name);
}
