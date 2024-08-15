import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name, e.position AS position, e.createdDate AS createdDate FROM Employee e WHERE e.department.id = :departmentId")
    Page<EmployeeProjection> findEmployeeProjectionsByDepartmentId(Long departmentId, Pageable pageable);

    @Query("SELECT e.id AS id, e.name AS name, e.position AS position, e.createdDate AS createdDate FROM Employee e WHERE e.name LIKE %:name%")
    Page<EmployeeProjection> findEmployeeProjectionsByNameContaining(String name, Pageable pageable);
}