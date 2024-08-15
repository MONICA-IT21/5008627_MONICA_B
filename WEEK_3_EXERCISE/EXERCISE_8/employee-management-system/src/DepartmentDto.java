

import java.time.LocalDateTime;

public class DepartmentDto {

    private Long id;
    private String name;
    private LocalDateTime createdDate;

    public DepartmentDto(Long id, String name, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    // Getters and setters
}
