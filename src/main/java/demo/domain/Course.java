package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Course {
    private final Integer id;
    private final String courseName;
    private CourseStats stats;
    private List<Log> logs;
}
