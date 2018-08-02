package demo.api;

import demo.domain.Course.Course;
import demo.domain.User.User;
import demo.domain.Course.CourseService;
import demo.domain.User.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/users")
public class UserResource {

    private final UserService users;
    private final CourseService courses;

    @Autowired
    public UserResource(UserService users, CourseService courses){
        this.users = users;
        this.courses = courses;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserResponse> getUsers() {
        return users.getUsers().stream().map(u ->
        {
            User user = users.getUser(u.getUserId());
            List<Course> courses = this.courses.getCourses(u.getUserId());
            return new UserResponse(user, courses);
        }).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{userId}")
    public void removeUser(@PathParam("userId") String id){
        users.removeUser(id);
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse getUser(@PathParam("userId") String id){
        return new UserResponse(users.getUser(id), courses.getCourses(id));
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

    @Data
    @RequiredArgsConstructor
    protected class UserResponse {
        private final User user;
        private final List<Course> courses;
    }
}
