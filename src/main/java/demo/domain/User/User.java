package demo.domain.User;
import demo.domain.Course.Course;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@RequiredArgsConstructor
public class User {
    @Id
    private String userId;
    private final String firstName;
    private final String lastName;
    private final String universityName;
    private List<Course> courses;
}
