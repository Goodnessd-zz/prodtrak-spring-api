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

    private final UserService users;

    @Inject
    public UserResource(UserService users){this.users = users;}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return users.getUsers();
    }

    @DELETE
    @Path("/{id}")
    public void removeUser(@PathParam("id") String id){
        users.removeUser(id);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") String id){
        return users.getUser(id);
    }

    @POST
    public void addUser(UserRequest user){
        users.addUser(user.createUser());
    }

    @Data
    static class UserRequest {
        @NotNull
        private String firstName;
        @NotNull
        private String lastName;
        @NotNull
        private String university;

        public User createUser(){
            return new User(firstName, lastName, university);
        }

    }
}
