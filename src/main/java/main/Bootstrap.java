package main;

import converter.PersonConverter;
import dto.UserDto;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.CaseRepository;
import repository.StatusRepository;
import service.CaseService;
import service.PersonService;
import service.SupervisorService;
import service.UserService;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    private UserService userService;
    private SupervisorService supervisorService;
    private StatusRepository statusRepository;
    private PersonService personService;
    private CaseService caseService;
    private CaseRepository caseRepository;
    private PersonConverter personConverter;

    @Autowired
    public Bootstrap(UserService userService, SupervisorService supervisorService, StatusRepository statusRepository, PersonService personService, CaseService caseService, CaseRepository caseRepository, PersonConverter personConverter) {
         this.userService = userService;
        this.supervisorService = supervisorService;
        this.statusRepository = statusRepository;
        this.personService = personService;
        this.caseService = caseService;
        this.caseRepository = caseRepository;
        this.personConverter = personConverter;
    }


    @PostConstruct
    private void initialize() {
        /*
        Role role = new Role("admin");
        roleRepository.save(role);

        role = new Role("supervisor");
        roleRepository.save(role);

        role = new Role("investigator");
        roleRepository.save(role);

        UserDto userDto = new UserDto();
        userDto.setName("ana");
        userDto.setUsername("anaa");
        userDto.setPassword("123");
        userDto.setRole("admin");

        userService.save(userDto);

        userDto = new UserDto();
        userDto.setName("party");
        userDto.setUsername("geret");
        userDto.setPassword("345");
        userDto.setRole("investigator");

        userService.save(userDto);

        userDto = new UserDto();
        userDto.setName("arty");
        userDto.setUsername("eret");
        userDto.setPassword("234");
        userDto.setRole("supervisor");

        userDto = userService.save(userDto);

        //Set<UserDto> investigators =  userService.findInvestigators();

       //UserDto userDto1 = userService.updateInvestigatorRole(userDto);
       //System.out.println(userDto1.getRole());

        PersonStatus status = new PersonStatus("criminal");
        statusRepository.save(status);

        status = new PersonStatus("suspect");
        statusRepository.save(status);


        status = new PersonStatus("witness");
        statusRepository.save(status);
           */

        /*
        UserDto userDto = new UserDto();
        userDto.setName("maria");
        userDto.setUsername("maryme");
        userDto.setPassword("345");
        userDto.setRole("supervisor");

        userService.save(userDto);

        PersonDto personDto = new PersonDto();
        personDto.setCNP("1134567891022");
        personDto.setName("dfsdghr");


        PersonStatus role1 = statusRepository.findByName("suspect");
        personDto.setStatus(role1.getName());

        personService.save(personDto);

        Set<PersonDto> persons = new HashSet<>();
        persons.add(personDto);

        Ccase ccase = caseRepository.getOne(new Long(11));
        ccase.setPersons(personConverter.convertToPersonList(persons));
        */
       // CaseDto caseDto = new CaseDto(ccase.getId(), personConverter.convertPersonList(ccase.getPersons()),ccase.isWarrantNeeded(), ccase.isWarrantObtained(),ccase.getCaseStatus());
       // caseService.update(caseDto);

        //UserDto userDto = new UserDto("carina.Test", "Parola123#", "Rina", null, Role.SUPERVISOR);

        //userService.save(userDto);
    }
}

