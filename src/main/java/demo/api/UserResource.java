package demo.api;

import demo.services.UserService;
import demo.domain.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/users")
public class UserResource {

    private static UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<User> getUsers() {
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static User getUser(){
        return userService.getUser();
    }
}
