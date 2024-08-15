import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.BatchSize;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @BatchSize(size = 10)  // Fetch 10 departments in a single query
    private Department department;

    // Getters and setters...
}

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    @Fetch(FetchMode.SUBSELECT)  // Load all related employees in one subselect
    private List<Employee> employees;

    // Getters and setters...
}

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN) // Fetch related department using join
    private Department department;

    // Getters and setters
}


@Entity
@FetchProfile(name = "Employee.detail", fetchOverrides = {
    @FetchProfile.FetchOverride(entity = Employee.class, association = "department", mode = FetchMode.JOIN)
})
public class Employee {
    // Entity details
}
