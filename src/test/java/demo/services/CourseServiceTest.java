package demo.services;

import demo.domain.Course.Course;
import demo.domain.Course.CourseService;
import demo.domain.Log.Log;
import demo.domain.User.User;
import demo.mongo.MemoryCourseRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static demo.dummyData.COURSE_ID;
import static demo.dummyData.USER_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class CourseServiceTest {

    public static final String LOG_ID = "1";
    CourseService courseService;

    @Before
    public void setup(){
        courseService = new CourseService(new MemoryCourseRepository());
    }

    @Test
    public void shouldGetSingleCourse() {
        Course course = courseService.getCourse(COURSE_ID);

        assertThat(course, is(notNullValue()));
        assertThat(course.getCourseName(), is(notNullValue()));
        assertThat(course.getLogs(), is(notNullValue()));
        assertThat(course.getStats(), is(notNullValue()));
    }

    @Test
    public void shouldGetAllCourses() {
        String userId = USER_ID;
        List<Course> courses = courseService.getCourses(userId);

        assertThat(courses.size() > 0, is(true));
    }

    @Test
    public void shouldGetSingleLogForCourse() {
        Log log = courseService.getLog(COURSE_ID, LOG_ID);

        assertThat(log.getDescription(), is(notNullValue()));
        assertThat(log.getDuration(), is(notNullValue()));
        assertThat(log.getId(), is(notNullValue()));
        assertThat(log.getTimestamp(), is(notNullValue()));
        assertThat(log.getType(), is(notNullValue()));
        assertThat(log.getName(), is(notNullValue()));
    }

    @Test
    public void shouldGetAllLogsForCourse(){
        List<Log> logs = courseService.getLogs(COURSE_ID);

        assertTrue(logs.size() > 0);
    }

    @Test
    public void shouldCreateIdForCourse(){
        Course test_course = new Course("test course");
        User user = new User("User", "mcDonald", "mcdonalds");
        assertThat(user, is(notNullValue()));
        assertThat(test_course, is(notNullValue()));
    }
}