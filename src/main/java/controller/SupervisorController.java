package controller;

import converter.UserConverter;
import dto.CaseDto;
import entity.Ccase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CaseService;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/supervisorPage")
public class SupervisorController {

    private CaseService caseService;
    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public SupervisorController(CaseService caseService, UserService userService, UserConverter userConverter) {
        this.caseService = caseService;
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping()
    public String getSupervisorPage(Model model) {
        model.addAttribute("caseDto", new CaseDto());
        List<Ccase> cases = caseService.getAll();
        model.addAttribute("cases", cases);

        return "supervisorPage";
    }

    @PostMapping(params = "addCase")
    public String addCase(@ModelAttribute CaseDto caseDto, Model model) {

        caseService.save(caseDto);
        List<Ccase> cases = caseService.getAll();
        model.addAttribute("cases", cases);
        return "supervisorPage";
    }
}
