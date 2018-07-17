package demo.api;

import demo.api.CourseResource.CourseRequest;
import demo.domain.Course.Course;
import demo.dummyData;
import demo.mongo.CourseRepository;
import demo.mongo.MemoryCourseRepository;
import demo.domain.Course.CourseService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static demo.dummyData.COURSE_ID;
import static demo.dummyData.USER_ID;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CourseResourceTest {


    public static final String COURSE_ID = "5678";
    private demo.domain.Course.CourseRepository mockRepo;
    private CourseService courseService;
    private CourseResource resource;
    private Course course;

    @Before
    public void setUp() throws Exception {
        mockRepo = mock(demo.domain.Course.CourseRepository.class);
        courseService = new CourseService(mockRepo);
        resource = new CourseResource(courseService);

        course = new Course("testCourse");
        course.setCourseId(COURSE_ID);

        when(mockRepo.get(COURSE_ID)).thenReturn(course);
    }

    @Test
    public void shouldGetCourse() {
        assertThat(resource.getCourse(COURSE_ID).getCourseId(), is(COURSE_ID));
    }

    @Test
    public void shouldGetMultipleCourses() {
        when(mockRepo.getAll(USER_ID)).thenReturn(Arrays.asList(course, course));

        List<Course> courses = resource.getCourses(USER_ID);

        assertTrue(courses.size() > 1);

    }

    @Test
    public void shouldRemoveCourse() {
        resource.removeCourse(COURSE_ID);

        verify(mockRepo, times(1)).remove(course);
    }

    @Test
    public void shouldAddNewCourse() {
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setName("testCourse");

        resource.createCourse(USER_ID, courseRequest);

        Course requestedCourse = courseRequest.toCourse();
        requestedCourse.setUserId(USER_ID);

        verify(mockRepo, times(1)).put(requestedCourse);
    }
}