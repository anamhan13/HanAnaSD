package service;

import dto.PersonDto;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    PersonDto update(PersonDto personDto);
}
