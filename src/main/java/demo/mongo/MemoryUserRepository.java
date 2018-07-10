package demo.mongo;

import demo.domain.User.User;
import demo.domain.User.UserRepository;
import demo.dummyData;

import java.util.List;

public class MemoryUserRepository implements UserRepository{

    @Override
    public User get(String id) {
        return dummyData.createUser("Goodness", "Daramola", "Cal Poly Pomona", "bio 101");
    }

    @Override
    public List<User> getAll() {
        return dummyData.createUsers();
    }

    @Override
    public void put(User user) {

    }

    @Override
    public void remove(User user) {

    }
}
