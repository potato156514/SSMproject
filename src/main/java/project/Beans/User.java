package project.Beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String password;
    private int type;
    private String phone;
    private String peopleID;
}
