package demo;

import demo.domain.Course;
import demo.domain.CourseStats;
import demo.domain.Log;
import demo.domain.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static demo.domain.LogType.PERSONAL_STUDY;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class dummyData{
    public static List<User> createUsers(){
        List<User> users = new ArrayList<>();

        User user1 = createUser(001, "Goodness", "Daramola", "Biology");
        User user2 = createUser(002, "Seun", "Akintolope", "Physics");

        return asList(user1, user2);
    }

    public static User createUser(int id, String firstName, String lastName, String courseName){
        User user = new User(id, firstName, lastName);
        user.setCourses(createCourses(101, courseName));
        user.setUniversityName("Cal Poly Pomona");

        return user;

    }

    public static List<Course> createCourses(int id, String courseName) {
        Course course1 = new Course(id, courseName);
        Course course2 = new Course(id, "Calculus");
        return Arrays.asList(course1, course2);
    }

    public static List<Course> createCourses() {
        return singletonList(createCourse());
    }

    public static Course createCourse() {
        Course course = new Course(123, "Biology 300");
        course.setLogs(createLogs());
        course.setStats(createStats());
        return course;
    }

    public static CourseStats createStats() {
        CourseStats courseStats = new CourseStats("B-", 58, 13);
        return courseStats;
    }

    public static Log createLog() {
        LocalDateTime localDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Log log = new Log(100, "Studied", localDateTime);
        log.setDescription("studied for hella long");
        log.setDuration(100);
        log.setType(PERSONAL_STUDY);

        return log;
    }

    public static List<Log> createLogs(){
        return Arrays.asList(createLog(), createLog());
    }
}
