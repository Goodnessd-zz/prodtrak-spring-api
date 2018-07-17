package demo.domain.User;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Role {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private RoleName name;

    public Role(){

    }

    public Role(RoleName name){
        this.name = name;
    }

}
