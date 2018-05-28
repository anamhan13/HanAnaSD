package service;

import dto.CaseDto;
import dto.UserDto;

import java.util.List;
import java.util.Set;

public interface SupervisorService {

    public CaseDto save(CaseDto caseDto);

    public UserDto save(UserDto userDto);

  //  public Set<UserDto> addInvestigatorToCase(UserDto userDto, CaseDto caseDto);

 //  public Set<UserDto> findInvestigators();

    public CaseDto updateCase(CaseDto caseDto);

   // public CaseDto removeInvestigatorFromCase(CaseDto caseDto, UserDto userDto);
}
