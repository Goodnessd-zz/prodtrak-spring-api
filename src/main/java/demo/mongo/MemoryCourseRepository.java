package demo.mongo;

import demo.domain.Course.Course;
import demo.domain.Course.CourseRepository;
import demo.dummyData;

import java.util.List;

public class MemoryCourseRepository implements CourseRepository{
    @Override
    public Course get(String id) {
        return dummyData.createCourse();
    }

    @Override
    public List<Course> getAll(String userId) {
        return dummyData.createCourses();
    }

    @Override
    public void put(Course course) {

    }

    @Override
    public void remove(Course course) {

    }
}
