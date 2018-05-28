package converter;

import dto.PersonDto;
import entity.Person;
import entity.PersonStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.StatusRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class PersonConverter {

    private StatusRepository statusRepository;

    @Autowired
    public PersonConverter(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Person convertToPerson(PersonDto personDto) {
        Person person = new Person();
        PersonStatus status = statusRepository.findByName(personDto.getStatus());

        person.setId(personDto.getId());
        person.setPersonStatus(status);
        person.setBirthday(personDto.getBirthday());
        person.setName(personDto.getName());
        person.setCnp(personDto.getCNP());

        return person;
    }

    public Set<Person> convertToPersonList(Set<PersonDto> PersonDtoList) {
        Set<Person> PersonList = new HashSet<>();

        for (PersonDto PersonDto : PersonDtoList)
            PersonList.add(convertToPerson(PersonDto));

        return PersonList;
    }

    public PersonDto convertPerson(Person person) {
        PersonDto personDto = new PersonDto();
        PersonStatus status = statusRepository.findByName(personDto.getStatus());

        personDto.setId(person.getId());
        personDto.setStatus(status.getName());
        personDto.setBirthday(person.getBirthday());
        personDto.setName(person.getName());
        personDto.setCNP(person.getCnp());

        return personDto;
    }

    public Set<PersonDto> convertPersonList(Set<Person> PersonList) {
        Set<PersonDto> PersonDtoList = new HashSet<>();

        for (Person Person: PersonList)
            PersonDtoList.add(convertPerson(Person));

        return PersonDtoList;
    }
}
