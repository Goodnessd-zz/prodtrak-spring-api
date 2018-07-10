package demo.mongo;

import demo.domain.Course.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoCourseRepository implements demo.domain.Course.CourseRepository {
    private final CourseRepository repository;

    public MongoCourseRepository(CourseRepository repository){this.repository = repository;}

    @Override
    public Course get(String id) {
        return repository.findByCourseId(id);
    }

    @Override
    public List<Course> getAll(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void put(Course course) {
        Course existingCourse = repository.findByCourseId(course.getCourseId());

        if(existingCourse != null){
            repository.save(course);
        }
        else{
            repository.insert(course);
        }
    }

    @Override
    public void remove(Course course) {
        repository.delete(course);
    }
}
