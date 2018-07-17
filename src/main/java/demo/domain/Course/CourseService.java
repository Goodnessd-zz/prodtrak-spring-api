package demo.domain.Course;

import demo.domain.Log.Log;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

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
            return emptyList();
        }
    }

    public Log getLog(String courseId, Integer logId) {
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
            courseRepository.put(course);
        }
        else {
            System.out.println("unable to create log");
        }
        System.out.println(course);
    }

    public void addCourse(String userId, Course course) {
        course.setUserId(userId);
        courseRepository.put(course);
    }

    public void deleteLog(String courseId, Integer logId) {
        Course course = courseRepository.get(courseId);

        Log log = getLog(courseId, logId);

        if(log != null){
            course.remove(log);
            courseRepository.put(course);
        }
    }

    public void removeCourse(String courseId) {
        Course course = getCourse(courseId);
        if(null != course){
        courseRepository.remove(course);
        }
    }
}
