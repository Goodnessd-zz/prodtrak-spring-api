package demo.domain.User;

import java.util.List;

public interface UserRepository {
    User get(String id);
    List<User> getAll();
    void put(User user);
    void remove(User user);

}
