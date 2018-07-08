package demo.domain.Course;

import demo.domain.Log.Log;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Course {

    @Id
    String id;
    private final String courseName;
    private CourseStats stats;
    private List<Log> logs;
}
