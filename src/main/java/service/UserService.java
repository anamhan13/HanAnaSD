package service;

import dto.UserDto;
import entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserDto save(UserDto userDto);

    Set<UserDto> findSupervisors();

    Set<UserDto> findInvestigators();

    UserDto updateInvestigatorRole(UserDto userDto);

    List<User> findAll();

}
