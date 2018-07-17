package demo.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import demo.domain.Course.CourseService;
import demo.domain.Course.Course;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users/{userId}/courses")

public class CourseResource {

    private CourseService courseService;

    @Autowired
    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(@PathParam("userId") String userId){
        return courseService.getCourses(userId);
    }

    @POST
    public void createCourse(@PathParam("userId") String userId, CourseRequest courseRequest){
        courseService.addCourse(userId, courseRequest.toCourse());
    }

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourse(@PathParam("courseId") String courseId){
        return courseService.getCourse(courseId);
    }

    @DELETE
    @Path("/{courseId}")
    public void removeCourse(@PathParam("courseId") String courseId){
        courseService.removeCourse(courseId);
    }

    @Data
    @JsonDeserialize
    public static class CourseRequest {
        @NotNull
        private String name;

        public Course toCourse() {
            return new Course(name);
        }
    }
}
