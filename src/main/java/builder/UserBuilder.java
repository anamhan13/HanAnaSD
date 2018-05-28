package builder;

import entity.Role;
import entity.User;

import java.util.Date;

public class UserBuilder {

    private long id;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private Role role;

    public UserBuilder() {}

    public UserBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name= name;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username= username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password= password;
        return this;
    }

    public UserBuilder setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role=role;
        return this;
    }

    public User build() {
        return new User(username, password, name, birthday, role);
    }
}
