package demo;

import demo.domain.Course.Course;
import demo.domain.Course.CourseStats;
import demo.domain.Log.Log;
import demo.domain.User.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static demo.domain.Log.LogType.PERSONAL_STUDY;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class dummyData{

    public static final String COURSE_ID = "5678";
    public static final String USER_ID = "1234";

    public static List<User> createUsers(){
        List<User> users = new ArrayList<>();

        User user1 = createUser("Goodness", "Daramola", "Cal Poly Pomona","Biology");
        User user2 = createUser("Seun", "Akintolope", "Cal State Long Beach", "Physics");

        return asList(user1, user2);
    }

    public static User createUser(String firstName, String lastName, String universityName, String courseName){
        User user = new User(firstName, lastName, universityName);
        user.setUserId("1234");
        user.setCourses(createCourses(courseName));
        return user;

    }

    public static List<Course> createCourses(String courseName) {
        Course course1 = new Course(courseName);
        course1.setCourseId(COURSE_ID);
        course1.setLogs(createLogs());
        course1.setStats(createStats());

        Course course2 = new Course("Calculus");
        course2.setCourseId(COURSE_ID);
        course2.setLogs(createLogs());
        course2.setStats(createStats());


        return Arrays.asList(course1, course2);
    }

    public static List<Course> createCourses() {
        return singletonList(createCourse());
    }

    public static Course createCourse() {
        Course course = new Course("Biology 300");
        course.setCourseId(COURSE_ID);
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
        Log log = new Log("Studied", localDateTime);
        log.setDescription("studied for hella long");
        log.setDuration(100);
        log.setType(PERSONAL_STUDY);
        log.setId("1");

        return log;
    }

    public static List<Log> createLogs(){
        return Arrays.asList(createLog(), createLog());
    }
}
