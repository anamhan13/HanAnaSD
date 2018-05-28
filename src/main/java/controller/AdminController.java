package controller;

import dto.UserDto;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/adminPage")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getCreate(Model model) {

        model.addAttribute("userDto", new UserDto());

        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "adminPage";
    }

    @PostMapping(params = "addUser")
    public String addCase(@ModelAttribute UserDto userDto, Model model) {

        userService.save(userDto);

        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "adminPage";
    }

}
