package service;

import converter.UserConverter;
import dto.UserDto;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = new User();
        if (!userDto.getName().trim().isEmpty()) {
            if (!userDto.getPassword().trim().isEmpty()) {
                if (!userDto.getRole().trim().isEmpty()) {
                    user.setName(userDto.getName());
                    user.setUsername(userDto.getUsername());
                    //bCryptPasswordEncoder.encode(userDto.getPassword())
                    user.setPassword(userDto.getPassword());
                    switch (userDto.getRole()) {
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

                    userRepository.save(user);
                    userDto.setId(user.getId());
                    return userDto;
                }
            }
        }
        return null;
    }

    @Override
    public Set<UserDto> findSupervisors() {
        Set<User> supervisors = userRepository.findByRole(Role.SUPERVISOR);
        Set<UserDto> supervisorsDto;
        if (supervisors.size()!=0) {
            supervisorsDto = new HashSet<>();
            for (User supervisor: supervisors) {
                supervisorsDto.add(userConverter.convertUser(supervisor));
            }
            return supervisorsDto;
        }
        return null;
    }

    @Override
    public Set<UserDto> findInvestigators() {
        Set<User> supervisors = userRepository.findByRole(Role.INVESTIGATOR);
        Set<UserDto> supervisorsDto;
        if (supervisors.size()!=0) {
            supervisorsDto = new HashSet<>();
            for (User supervisor: supervisors) {
                supervisorsDto.add(userConverter.convertUser(supervisor));
            }
            return supervisorsDto;
        }
        return null;
    }

    @Override
    public UserDto updateInvestigatorRole(UserDto userDto) {
        if (userDto.getRole().equals("INVESTIGATOR")) {
            userDto.setRole("SUPERVISOR");
            User user = userRepository.findByUsername(userDto.getUsername());
            user.setRole(Role.SUPERVISOR);
            userRepository.save(user);
            return userDto;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
