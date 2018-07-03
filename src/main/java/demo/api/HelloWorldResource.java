package demo.api;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/helloworld")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorldResponse helloMessage(){
        return new HelloWorldResponse("hello world");
    }

    @Data
    private class HelloWorldResponse {
        private final String message;
    }
}