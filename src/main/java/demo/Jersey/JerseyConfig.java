package demo.Jersey;

import demo.api.HelloWorldResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(HelloWorldResource.class);
    }
}
