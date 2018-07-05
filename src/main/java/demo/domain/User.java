package demo.domain;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Data
@RequiredArgsConstructor
public class User {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private String universityName;
    private List<Course> courses;
}
