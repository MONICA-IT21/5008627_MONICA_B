import java.time.LocalDateTime;

public interface DepartmentProjection {

    Long getId();
    String getName();
    LocalDateTime getCreatedDate();
}
