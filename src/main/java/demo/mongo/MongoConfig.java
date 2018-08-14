package demo.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackages = "demo.mongo")
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class MongoConfig{
    private final String uri;
    private MongoClient mongoClient;


    @Autowired
    public MongoConfig(@Value("${spring.mongodb.uri}") String uri){
        System.out.println(uri);
        this.uri = uri;
        this.mongoClient = new MongoClient(new MongoClientURI(uri));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoClient, "demo");
    }
}
