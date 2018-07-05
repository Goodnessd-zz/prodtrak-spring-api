package demo.api;

import demo.Services.CourseService;
import demo.domain.Course;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
public class CourseResource {

    private CourseService courseService = new CourseService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourse(){
        return courseService.getCourse();
    }


}
