package demo.domain.Course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import demo.domain.Log.Log;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    @Id
    private String courseId;
    private String userId;
    private final String courseName;
    private CourseStats stats = new CourseStats(null, null,null);
    private List<Log> logs = new ArrayList<>();

    public void addLog(Log log) {
        logs.add(log);
    }
}
