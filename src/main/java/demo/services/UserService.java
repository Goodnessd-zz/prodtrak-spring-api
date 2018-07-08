package demo.services;

import demo.domain.User.User;
import demo.domain.User.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository users){
        this.repository = users;
    }

    public List<User> getUsers() {
        return repository.getAll();
    }

    public void addUser(User user){
        repository.put(user);
    }

    public User getUser(String id) {
        User user = repository.get(id);
        return user;
    }

    public void removeUser(String id) {
        User user = repository.get(id);
        repository.remove(user);
    }
}
