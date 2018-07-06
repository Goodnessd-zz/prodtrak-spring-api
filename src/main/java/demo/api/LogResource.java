package demo.api;

import demo.services.CourseService;
import demo.domain.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users/{userId}/logs")
public class LogResource {

    CourseService courseService = new CourseService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Log> getLogs(@PathParam("userId") Integer userId){
        return courseService.getLogs(userId);
    }

    @GET
    @Path("/{logId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Log getSingleLog(@PathParam("userId") Integer userId, @PathParam("logId") Integer logId){
        return courseService.getLog(userId, logId);
    }
}
