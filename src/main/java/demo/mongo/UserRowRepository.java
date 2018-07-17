package demo.mongo;

import demo.domain.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRowRepository extends MongoRepository<User, String>{
    User findByUserId(String id);

    User findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);
}
