package demo.domain.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import demo.domain.Course.Course;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String userId;
    private final String firstName;
    private final String lastName;
    private final String universityName;
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        course.setUserId(userId);
        courses.add(course);
    }
}
