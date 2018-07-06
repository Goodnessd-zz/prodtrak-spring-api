package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Course {

    @Id private Long id;
    private final String courseName;
    private CourseStats stats;
    private List<Log> logs;
}
