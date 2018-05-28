package converter;

import dto.UserDto;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserConverter {

    @Autowired
    public UserConverter() {}

    public User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        switch(userDto.getRole()) {
            case "ADMIN":
                user.setRole(Role.ADMIN);
                break;
            case "INVESTIGATOR":
                user.setRole(Role.INVESTIGATOR);
                break;
            case "SUPERVISOR":
                user.setRole(Role.SUPERVISOR);
                break;
            default:
                user.setRole(null);
                break;
        }
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());

        return user;
    }

    public Set<User> convertToUserList(Set<UserDto> userDtoList) {
        Set<User> userList = new HashSet<>();

        for (UserDto userDto : userDtoList)
            userList.add(convertToUser(userDto));

        return userList;
    }

    public UserDto convertUser(User user) {
        UserDto userDto = new UserDto();

        userDto.setRole(user.getRole().name());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setId(user.getId());

        return userDto;
    }

    public Set<UserDto> convertUserList(Set<User> userList) {
        Set<UserDto> userDtoList = new HashSet<>();

        for (User user: userList)
            userDtoList.add(convertUser(user));

        return userDtoList;
    }
}
