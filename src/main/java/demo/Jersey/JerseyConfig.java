package demo.Jersey;

import demo.api.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(UserResource.class);
    }
}
