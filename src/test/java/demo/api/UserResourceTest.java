package demo.api;

import demo.domain.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class UserResourceTest {

    @Test
    public void shouldReturnListOfStudents(){
        List<User> users = UserResource.getUsers();

        assertThat(users, is(notNullValue()));
    }
}