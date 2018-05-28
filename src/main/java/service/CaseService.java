package service;

import dto.CaseDto;
import entity.Ccase;

import java.util.List;

public interface CaseService {

    public CaseDto save(CaseDto caseDto);

    public CaseDto update(CaseDto caseDto);

    public List<CaseDto> findAll();

    List<Ccase> getAll();
}
