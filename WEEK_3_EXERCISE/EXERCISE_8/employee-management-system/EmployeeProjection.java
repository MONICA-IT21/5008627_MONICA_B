import java.time.LocalDateTime;

public interface EmployeeProjection {

    Long getId();
    String getName();
    String getPosition();
    LocalDateTime getCreatedDate();
}
