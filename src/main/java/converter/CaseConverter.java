package converter;

import dto.CaseDto;
import entity.Ccase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CaseConverter {

    private PersonConverter personConverter;
    private UserConverter userConverter;

    @Autowired
    public CaseConverter(PersonConverter personConverter, UserConverter userConverter) {
        this.personConverter = personConverter;
        this.userConverter = userConverter;
    }

    public Ccase convertToCcase(CaseDto ccaseDto) {
        Ccase ccase = new Ccase();

        ccase.setId(ccaseDto.getId());
        ccase.setCaseStatus(ccaseDto.getStatus());
        ccase.setSupervisor(ccaseDto.getSupervisor());
        ccase.setWarrantObtained(ccaseDto.isWarrantObtained());
        ccase.setWarrantNeeded(ccaseDto.isWarrantNeeded());
        ccase.setPersons(personConverter.convertToPersonList(ccaseDto.getPersons()));
        return ccase;
    }

    public Set<Ccase> convertToCcaseList(Set<CaseDto> caseDtoList) {
        Set<Ccase> ccaseList = new HashSet<>();

        for (CaseDto ccaseDto : caseDtoList)
            ccaseList.add(convertToCcase(ccaseDto));

        return ccaseList;
    }

    public CaseDto convertCcase(Ccase ccase) {
        CaseDto ccaseDto = new CaseDto();

        ccaseDto.setId(ccase.getId());
        ccaseDto.setStatus(ccase.getCaseStatus());
        ccaseDto.setWarrantObtained(ccase.isWarrantObtained());
        ccaseDto.setWarrantNeeded(ccase.isWarrantNeeded());
        ccaseDto.setPersons(personConverter.convertPersonList(ccase.getPersons()));

        return ccaseDto;
    }

    public Set<CaseDto> convertCcaseList(Set<Ccase> ccaseList) {
        Set<CaseDto> ccaseDtoList = new HashSet<>();

        for (Ccase Ccase: ccaseList)
            ccaseDtoList.add(convertCcase(Ccase));

        return ccaseDtoList;
    }
}
