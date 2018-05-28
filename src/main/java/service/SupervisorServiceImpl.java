package service;

import builder.UserBuilder;
import converter.PersonConverter;
import converter.UserConverter;
import dto.CaseDto;
import dto.UserDto;
import entity.Ccase;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CaseRepository;
import repository.SupervisorRepository;
import repository.UserRepository;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    private UserRepository userRepository;
    private CaseRepository caseRepository;
    private CaseService caseService;

    @Autowired
    public SupervisorServiceImpl(UserRepository userRepository, CaseRepository caseRepository, CaseService caseService) {
        this.userRepository = userRepository;
        this.caseRepository = caseRepository;
        this.caseService = caseService;
    }



    @Override
    public CaseDto save(CaseDto caseDto) {
        caseService.save(caseDto);
        return caseDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = (new UserBuilder())
                    .setName(userDto.getName())
                    .setUsername(userDto.getUsername())
                    .setPassword(userDto.getPassword())
                    .setRole(null)
                    .build();
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

        userRepository.save(user);

        return userDto;
    }
/*
    @Override
    public Set<UserDto> addInvestigatorToCase(UserDto userDto, CaseDto caseDto) {
        Ccase criminalCase;
        User user = userRepository.getOne(userDto.getId());
        if (user != null) {
            criminalCase = caseRepository.getOne(caseDto.getId());
            if (criminalCase != null) {
                if (!criminalCase.getInvestigators().contains(user)) {
                    criminalCase.getInvestigators().add(user);
                    caseRepository.save(criminalCase);
                }
                return userConverter.convertUserList(criminalCase.getInvestigators());
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Set<UserDto> findInvestigators() {
        Role role = roleRepository.findByName("investigator");
        Set<User> supervisors = userRepository.findByRole(role);
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
*/
    @Override
    public CaseDto updateCase(CaseDto caseDto) {
        Ccase ccase = caseRepository.getOne(caseDto.getId());

        if (ccase != null) {
            //User supervisor = userRepository.getOne(caseDto.getSupervisor());

            ccase.setSupervisor(caseDto.getSupervisor());
            ccase.setCaseStatus(caseDto.getStatus());
            //VERY CAREFUL HERE CA MA ASTEPT SA MESS THIS UP
            ccase.setWarrantNeeded(caseDto.isWarrantNeeded());
            if (!caseDto.isWarrantObtained() && caseDto.isWarrantNeeded())
                ccase.setWarrantObtained(caseDto.isWarrantObtained());

            caseRepository.save(ccase);
            return caseDto;
        }

        return null;
    }
/*
    @Override
    public CaseDto removeInvestigatorFromCase(CaseDto caseDto, UserDto userDto) {
        Ccase criminalCase = caseRepository.getOne(caseDto.getId());
        if (criminalCase != null) {
            User investigator = userRepository.getOne(userDto.getId());
            if (criminalCase.getInvestigators().contains(investigator)) {
                criminalCase.getInvestigators().remove(investigator);
                caseRepository.save(criminalCase);
            }
            return caseDto;
        }
        return null;
    }*/
}
