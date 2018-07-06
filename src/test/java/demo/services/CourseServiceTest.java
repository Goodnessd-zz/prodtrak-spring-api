package demo.services;

import demo.domain.Course;
import demo.domain.Log;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class CourseServiceTest {

    CourseService courseService;

    @Before
    public void setup(){
        courseService = new CourseService();
    }

    @Test
    public void shouldGetSingleCourse() {
        Course course = courseService.getCourse();

        assertThat(course, is(notNullValue()));
        assertThat(course.getCourseName(), is(notNullValue()));
        assertThat(course.getId(), is(notNullValue()));
        assertThat(course.getLogs(), is(notNullValue()));
        assertThat(course.getStats(), is(notNullValue()));
    }

    @Test
    public void shouldGetAllCourses() {
        List<Course> courses = courseService.getCourses();

        assertThat(courses.size() > 0, is(true));
    }

    @Test
    public void shouldGetSingleLogForCourse() {
        Log log = courseService.getLog(100, 1);

        assertThat(log.getDescription(), is(notNullValue()));
        assertThat(log.getDuration(), is(notNullValue()));
        assertThat(log.getId(), is(notNullValue()));
        assertThat(log.getTimestamp(), is(notNullValue()));
        assertThat(log.getType(), is(notNullValue()));
        assertThat(log.getName(), is(notNullValue()));
    }

    @Test
    public void shouldGetAllLogsForCourse(){
        List<Log> logs = courseService.getLogs(100);

        assertTrue(logs.size() > 0);
    }
}