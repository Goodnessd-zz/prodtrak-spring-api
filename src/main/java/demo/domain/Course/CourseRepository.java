package demo.domain.Course;

import java.util.List;

public interface CourseRepository {
    Course get(String id);
    List<Course> getAll(String userId);
    void put(Course course);
    void remove(Course course);

}
