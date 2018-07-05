package demo;

import demo.domain.Course;
import demo.domain.User;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class dummyData{
    public static List<User> createUsers(){
        List<User> users = new ArrayList<>();

        User user1 = createUser(001, "Goodness", "Daramola", "Biology");
        User user2 = createUser(002, "Seun", "Akintolope", "Physics");

        return asList(user1, user2);
    }

    public static User createUser(int id, String firstName, String lastName, String courseName){
        User user = new User(id, firstName, lastName);
        user.setCourses(createCourse(101, courseName));
        user.setUniversityName("Cal Poly Pomona");

        return user;

    }

    private static List<Course> createCourse(int id, String courseName) {
        Course course = new Course(id, courseName);
        return singletonList(course);
    }

}
