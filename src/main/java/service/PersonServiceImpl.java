package service;

import builder.PersonBuilder;
import dto.PersonDto;
import entity.Person;
import entity.PersonStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonRepository;
import repository.StatusRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private StatusRepository statusRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, StatusRepository statusRepository) {
        this.personRepository = personRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        PersonStatus status = statusRepository.findByName(personDto.getStatus());

        Person person = (new PersonBuilder())
                        .setId(personDto.getId())
                        .setName(personDto.getName())
                        .setCNP(personDto.getCNP())
                        .setBirthday(personDto.getBirthday())
                        .setStatus(status)
                        .build();

        personRepository.save(person);

        return personDto;
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        return null;
    }
}
