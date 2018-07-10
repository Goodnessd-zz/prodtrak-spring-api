package demo.api;

import demo.domain.Course.Course;
import demo.mongo.MemoryCourseRepository;
import demo.services.CourseService;
import org.junit.Test;

import static demo.dummyData.COURSE_ID;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CourseResourceTest {


    @Test
    public void shouldReturnSpecificCourse() {
        //given
        CourseService courseService = new CourseService(new MemoryCourseRepository());
        CourseResource response = new CourseResource(courseService);

        //when
        String courseId = "5678";
        Course course = response.getCourse(courseId);

        //then
        assertThat(course.getCourseId(), is(COURSE_ID));
    }
}