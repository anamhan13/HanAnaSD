package dto;

import entity.Ccase;
import entity.Person;

import java.util.HashSet;
import java.util.Set;

public class CaseDto {

    private long id;
    private long supervisor;


    //private Set<UserDto> users = new HashSet<>();
    private Set<PersonDto> persons = new HashSet<>();

    private boolean warrantNeeded;
    private boolean warrantObtained;
    private String status;

    public CaseDto() {}

    public CaseDto(long supervisor, boolean warrantNeeded, String status) {
        this.supervisor = supervisor;
        this.warrantNeeded = warrantNeeded;
        this.status = status;
    }

    public CaseDto(long supervisor, boolean warrantNeeded, boolean warrantObtained, String status) {
        this.supervisor = supervisor;
        this.warrantNeeded = warrantNeeded;
        this.warrantObtained = warrantObtained;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(long supervisor) {
        this.supervisor = supervisor;
    }

    public boolean isWarrantNeeded() {
        return warrantNeeded;
    }

    public void setWarrantNeeded(boolean warrantNeeded) {
        this.warrantNeeded = warrantNeeded;
    }

    public boolean isWarrantObtained() { return warrantObtained; }

    public void setWarrantObtained(boolean warrantObtained) {
        this.warrantObtained = warrantObtained;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }
*/
    public Set<PersonDto> getPersons() {
        return persons;
    }

    public void setPersons(Set<PersonDto> persons) {
        this.persons = persons;
    }
}
