package demo.mongo;

import demo.domain.Course.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> findByUserId(String id);
    Course findByCourseId(String id);
}
