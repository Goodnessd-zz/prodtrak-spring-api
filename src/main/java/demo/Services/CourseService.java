package demo.Services;

import demo.domain.Course;
import demo.domain.Log;
import demo.dummyData;

import java.util.List;

public class CourseService {
    public List<Course> getCourses() {
        return dummyData.createCourses();
    }

    public Course getCourse() {
        return dummyData.createCourse();
    }

    public List<Log> getLogs(Integer userId) {
        return dummyData.createLogs();
    }

    public Log getLog(Integer userId, int logId) {
        return dummyData.createLog();
    }
}
