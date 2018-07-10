package demo.api;

import demo.mongo.MemoryCourseRepository;
import demo.mongo.MemoryUserRepository;
import demo.domain.Course.CourseService;
import demo.domain.User.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class UserResourceTest {
    private UserResource userResource;

    @Before
    public void setUp(){
        UserService users = new UserService(new MemoryUserRepository());
        CourseService courses = new CourseService(new MemoryCourseRepository());
        userResource = new UserResource(users, courses);
    }

    @Test
    public void shouldReturnListOfStudents(){
        List<UserResource.UserResponse> users = userResource.getUsers();

        assertThat(users, is(notNullValue()));
    }
}