package demo.mongo;

import demo.domain.User.User;
import demo.domain.User.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoUserRepository implements UserRepository{
    private final UserRowRepository repository;

    public MongoUserRepository(UserRowRepository repository){
        this.repository = repository;
    }

    @Override
    public User get(String id) {
        User user = repository.findByUserId(id);
        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void put(User user) {
        User existingUser = repository.findByUserId(user.getUserId());

        if(existingUser != null){
            repository.save(user);
        }
        else{
            repository.insert(user);
        }
    }

    @Override
    public void remove(User user) {
        repository.delete(user);
    }
}
