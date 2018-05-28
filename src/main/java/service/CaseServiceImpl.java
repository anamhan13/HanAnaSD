package service;

import builder.CaseBuilder;
import converter.CaseConverter;
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
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CaseServiceImpl implements CaseService {

    private CaseRepository caseRepository;
    private CaseConverter caseConverter;
    private UserRepository userRepository;

    @Autowired
    public CaseServiceImpl(CaseRepository caseRepository, CaseConverter caseConverter, UserRepository userRepository) {
        this.caseRepository = caseRepository;
        this.caseConverter = caseConverter;
        this.userRepository = userRepository;
    }

    @Override
    public CaseDto save(CaseDto caseDto) {
        User supervisor = userRepository.getOne(caseDto.getSupervisor());
        if (supervisor != null) {
            Ccase ccase = (new CaseBuilder())
                    .setSupervisor(caseDto.getSupervisor())
                    .setStatus(caseDto.getStatus())
                    .setObtained(false)
                    .setNeeded(caseDto.isWarrantNeeded())
                    //.setPersons(personConverter.convertToPersonList(caseDto.getPersons()))
                    .build();
            caseRepository.save(ccase);
            return caseDto;
        }
       return null;
    }

    @Override
    public CaseDto update(CaseDto caseDto) {
        Ccase ccase;
        if (caseDto != null) {
            ccase  = caseRepository.getOne(caseDto.getId());

            if (ccase != null) {
                User supervisor = userRepository.getOne(caseDto.getSupervisor());

                if (!caseDto.getStatus().trim().isEmpty())
                    ccase.setCaseStatus(caseDto.getStatus());
                ccase.setWarrantNeeded(caseDto.isWarrantNeeded());
                ccase.setWarrantObtained(caseDto.isWarrantObtained());
                if (supervisor != null && supervisor.getId() != 0 && supervisor.getRole().equals(Role.SUPERVISOR))
                    ccase.setSupervisor(caseDto.getSupervisor());
                //ccase.setPersons(personConverter.convertToPersonList(caseDto.getPersons()));

                caseRepository.save(ccase);

                return caseDto;
            }
            return null;
        }
        return null;
    }

    @Override
    public List<CaseDto> findAll() {
        List<Ccase> cases = caseRepository.findAll();
        List<CaseDto> casesDto;

        if (cases.size()!=0) {
            casesDto = new ArrayList<>();
            for (Ccase ccase: cases) {
                casesDto.add(caseConverter.convertCcase(ccase));
            }
            return casesDto;
        }
        return null;
    }

    @Override
    public List<Ccase> getAll() {
        return caseRepository.findAll();
    }
}
