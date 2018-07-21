package demo.domain.Course;

import demo.domain.Log.Log;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getCourses(String userId) {
        return courseRepository.getAll(userId);
    }

    public Course getCourse(String courseId) {
        return courseRepository.get(courseId);
    }

    public List<Log> getLogs(String courseId) {
        Course course = courseRepository.get(courseId);
        if(null != course){
            return course.getLogs();
        }
        else{
            return null;
        }
    }

    public Log getLog(String courseId, String logId) {
        Course course = courseRepository.get(courseId);
        if (null != course) {
            return course.getLogs().stream().filter(log -> log.getId().equals(logId)).findFirst().orElse(null);
        }
        else
            return null;
    }

    public void createLog(String courseId, Log log) {
        Course course = courseRepository.get(courseId);
        if(null != course){
            course.addLog(log);
        }
        else {
            System.out.println("unable to create log");
        }
    }

    public void addCourse(String userId, Course course) {
        course.setUserId(userId);
        courseRepository.put(course);
    }
}
