import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByDepartmentId", 
                query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"),
    @NamedQuery(name = "Employee.findByNameContaining", 
                query = "SELECT e FROM Employee e WHERE e.name LIKE %:name%"),
    @NamedQuery(name = "Employee.findByPosition", 
                query = "SELECT e FROM Employee e WHERE e.position = :position")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;

    @ManyToOne
    private Department department;

    // Getters and Setters
}
