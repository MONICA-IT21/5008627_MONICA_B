

import java.time.LocalDateTime;

public class EmployeeDto {

    private Long id;
    private String name;
    private String position;
    private LocalDateTime createdDate;

    public EmployeeDto(Long id, String name, String position, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.createdDate = createdDate;
    }

    // Getters and setters
}
