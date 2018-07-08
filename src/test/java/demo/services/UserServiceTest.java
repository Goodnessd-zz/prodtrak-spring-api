package demo.services;

import demo.domain.User.User;
import demo.domain.User.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void shouldGetSingleUser(){
        User user = userService.getUser();

        assertThat(user.getCourses(), is(notNullValue()));
        assertThat(user.getFirstName(), is(notNullValue()));
        assertThat(user.getLastName(), is(notNullValue()));
        assertThat(user.getUniversityName(), is(notNullValue()));
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    public void shouldGetListOfUsers() {
        List<User> users = userService.getUsers();

        assertTrue(users.size() > 0);
    }


}