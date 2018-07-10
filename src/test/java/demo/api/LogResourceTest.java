package demo.api;

import demo.domain.Log.Log;
import demo.mongo.MemoryCourseRepository;
import demo.domain.Course.CourseService;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogResourceTest {

    @Test
    public void shouldGetListOfLogs() {
        CourseService courseService = new CourseService(new MemoryCourseRepository());
        LogResource logResource = new LogResource(courseService);

        String userId = "1234";
        String courseId = "5678";
        List<Log> logs = logResource.getLogs(courseId);

        assertThat(logs.size(), is(2));
    }
}