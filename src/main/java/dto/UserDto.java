package dto;

import entity.Role;

import java.util.Date;

public class UserDto {

    private long id;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private Role role;

    public UserDto(String username, String password, String name, Date birthday, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
    }

    public UserDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
