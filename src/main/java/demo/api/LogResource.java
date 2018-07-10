package demo.api;

import demo.domain.Course.CourseService;
import demo.domain.Log.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Component
@Path("/users/{userId}/courses/{courseId}/logs")
public class LogResource {

    private CourseService courseService;

    @Autowired
    public LogResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Log> getLogs(@PathParam("courseId") String courseId){
        return courseService.getLogs(courseId);
    }

    @POST
    public void createLog(@PathParam("courseId") String courseId, LogRequest logRequest){
        courseService.createLog(courseId, logRequest.toLog());
    }

    @GET
    @Path("/{logId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Log getSingleLog(@PathParam("courseId") String courseId, @PathParam("logId") String logId){
        return courseService.getLog(courseId, logId);
    }

    @RequiredArgsConstructor
    public static class LogRequest {
        private final String name;

        LocalDateTime localDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();

        public Log toLog() {
            return new Log(name, localDateTime);
        }
    }
}
