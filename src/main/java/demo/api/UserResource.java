package demo.api;

import demo.domain.User.User;
import demo.services.UserService;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
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
