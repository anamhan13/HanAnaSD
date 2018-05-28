package converter;

import dto.UserDto;
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
        user.setRole(userDto.getRole());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setBirthday(userDto.getBirthday());
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

        userDto.setRole(user.getRole());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setBirthday(user.getBirthday());
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
