import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate  // Only update the fields that have been modified
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and setters...
}
