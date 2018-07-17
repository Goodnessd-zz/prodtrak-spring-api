package demo.api;

import demo.domain.Log.Log;
import demo.mongo.MemoryCourseRepository;
import demo.domain.Course.CourseService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static demo.dummyData.COURSE_ID;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class LogResourceTest {

    private CourseService courseService;
    private LogResource logResource;

    @Before
    public void setUp() throws Exception {
        courseService = new CourseService(new MemoryCourseRepository());
        logResource = new LogResource(courseService);
    }

    @Test
    public void shouldGetListOfLogs() {
        List<Log> logs = logResource.getLogs(COURSE_ID);

        assertThat(logs.size(), is(2));
    }

    @Test
    public void shouldGetLog() {
        Log log = logResource.getLog(COURSE_ID, 1);

        assertThat(log, is(notNullValue()));
    }
}