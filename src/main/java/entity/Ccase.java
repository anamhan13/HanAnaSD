package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Ccase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long supervisor;

    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "ccase_user",
            joinColumns = {@JoinColumn(name = "fk_user")},
            inverseJoinColumns = {@JoinColumn(name = "fk_ccase")})

    @Transient
    private Set<User> users = new HashSet<>();
    */

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "case_person",
            joinColumns = {@JoinColumn(name = "ccase_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")})
    private Set<Person> persons = new HashSet<>();


    private boolean warrantNeeded;
    private boolean warrantObtained;
    private String caseStatus;

    public Ccase() {}

    public Ccase(long supervisor, boolean warrantNeeded, boolean warrantObtained, String status) {
        this.supervisor = supervisor;
        this.warrantNeeded = warrantNeeded;
        this.warrantObtained = warrantObtained;
        this.caseStatus = status;
    }

    public Ccase(long supervisor, Set<Person> persons, boolean warrantNeeded, boolean warrantObtained, String caseStatus) {
        this.supervisor = supervisor;
        this.persons = persons;
        this.warrantNeeded = warrantNeeded;
        this.warrantObtained = warrantObtained;
        this.caseStatus = caseStatus;
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

    /*
    public Set<User> getUsers() {
        return users;
    }


    public void setUsers(Set<User> users) {
        this.users = users;
    }
    */
    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public boolean isWarrantNeeded() {
        return warrantNeeded;
    }

    public void setWarrantNeeded(boolean warrantNeeded) {
        this.warrantNeeded = warrantNeeded;
    }

    public boolean isWarrantObtained() {
        return warrantObtained;
    }

    public void setWarrantObtained(boolean warrantObtained) {
        this.warrantObtained = warrantObtained;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }
}
