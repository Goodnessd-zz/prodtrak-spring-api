package demo.Services;

import demo.domain.User;
import demo.dummyData;

import java.util.List;

public class UserService {
    public List<User> getUsers() {
        return dummyData.createUsers();
    }

    public User getUser() {
        return dummyData.createUser(123, "Seun", "Akintolope", "Biology");
    }
}
