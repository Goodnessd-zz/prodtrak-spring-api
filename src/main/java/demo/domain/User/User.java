package demo.domain.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private String userId;
    private final String firstName;
    private final String lastName;
    private final String universityName;
    private final String username;
    private final String email;
    private final String password;
    private List<Role> roles;

    public String getName(){
        return firstName + " " + lastName;
    }


}
