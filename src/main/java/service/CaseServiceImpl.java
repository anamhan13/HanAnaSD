package service;

import builder.CaseBuilder;
import converter.PersonConverter;
import converter.UserConverter;
import dto.CaseDto;
import entity.Ccase;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CaseRepository;
import repository.UserRepository;

@Service
public class CaseServiceImpl implements CaseService {

    private CaseRepository caseRepository;
    private UserRepository userRepository;
    private UserConverter userConverter;
    private PersonConverter personConverter;


    @Autowired
    public CaseServiceImpl(CaseRepository caseRepository, UserRepository userRepository, UserConverter userConverter, PersonConverter personConverter) {
        this.caseRepository = caseRepository;
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.personConverter = personConverter;
    }

    @Override
    public CaseDto save(CaseDto caseDto) {
        //User supervisor = userRepository.getOne(caseDto.getSupervisor());
        Ccase ccase = (new CaseBuilder())
                            .setSupervisor(caseDto.getSupervisor())
                            .setStatus(caseDto.getStatus())
                            .setObtained(caseDto.isWarrantObtained())
                            .setNeeded(caseDto.isWarrantNeeded())
                            .setPersons(personConverter.convertToPersonList(caseDto.getPersons()))
                            .build();
        caseRepository.save(ccase);

        return caseDto;
    }

    @Override
    public CaseDto update(CaseDto caseDto) {
        Ccase ccase;
        if (caseDto != null) {
            ccase  = caseRepository.getOne(caseDto.getId());

            if (ccase != null) {
                ccase.setCaseStatus(caseDto.getStatus());
                ccase.setWarrantNeeded(caseDto.isWarrantNeeded());
                ccase.setWarrantObtained(caseDto.isWarrantObtained());
                ccase.setSupervisor(caseDto.getSupervisor());
                ccase.setPersons(personConverter.convertToPersonList(caseDto.getPersons()));

                caseRepository.save(ccase);
            }
            return null;
        }
        return null;
    }
}
