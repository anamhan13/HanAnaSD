package service;

import dto.CaseDto;

public interface CaseService {

    public CaseDto save(CaseDto caseDto);

    public CaseDto update(CaseDto caseDto);
}
