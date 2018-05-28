package builder;

import converter.PersonConverter;
import converter.UserConverter;
import entity.Ccase;
import entity.Person;

import java.util.HashSet;
import java.util.Set;

public class CaseBuilder {

    private long id;
    private long supervisor;
    /*
    private Set<User> investigators = new HashSet<>();
    private Set<Person> witnesses = new HashSet<>();
    */

    private Set<Person> persons = new HashSet<>();
    private boolean warrantNeeded;
    private boolean warrantObtained;
    private String status;

    public CaseBuilder() {}

    public CaseBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public CaseBuilder setSupervisor(long supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    /*
    public CaseBuilder setInvestigators(Set<User> investigators) {
        this.investigators = investigators;
        return this;
    }

    public CaseBuilder setWitnesses(Set<Person> witnesses) {
        this.witnesses = witnesses;
        return this;
    }

    }
    */

    public CaseBuilder setPersons(Set<Person> persons) {
        if (persons == null)
            persons = new HashSet<>();
        this.persons = persons;
        return this;
    }

    public CaseBuilder setNeeded(boolean needed) {
        this.warrantNeeded = needed;
        return this;
    }

    public CaseBuilder setObtained(boolean obtained) {
        this.warrantObtained = obtained;
        return this;
    }

    public CaseBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Ccase build() {
        return new Ccase(supervisor, warrantObtained, warrantNeeded, status);
    }

}
