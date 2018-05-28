package builder;

import entity.Person;
import entity.PersonStatus;

import java.util.Date;
import java.util.Set;

public class PersonBuilder {

    private long id;
    private String CNP;
    private String name;
    private Date birthday;
    private PersonStatus status;

    public PersonBuilder() {}

    public PersonBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setCNP(String cnp) {
        this.CNP = cnp;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name= name;
        return this;
    }

    public PersonBuilder setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public PersonBuilder setStatus(PersonStatus status) {
        this.status = status;
        return this;
    }

    public Person build() {
        return new Person(CNP, name, birthday, status);
    }

}
