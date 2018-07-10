package demo.services;

import demo.domain.User.User;
import demo.domain.User.UserRepository;
import demo.mongo.MemoryUserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static demo.dummyData.USER_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(new MemoryUserRepository());
    }

    @Test
    public void shouldGetSingleUser(){
        User user = userService.getUser(USER_ID);

        assertThat(user.getCourses(), is(notNullValue()));
        assertThat(user.getFirstName(), is(notNullValue()));
        assertThat(user.getLastName(), is(notNullValue()));
        assertThat(user.getUniversityName(), is(notNullValue()));
        assertThat(user.getUserId(), is(notNullValue()));
    }

    @Test
    public void shouldGetListOfUsers() {
        List<User> users = userService.getUsers();

        assertTrue(users.size() > 0);
    }


}