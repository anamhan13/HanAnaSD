package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String cnp;
    @Column
    private String name;
    @Column
    private Date birthday;

    @ManyToOne
    @JoinColumn(name="status_id")
    private PersonStatus personStatus;

    //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "persons",cascade = CascadeType.MERGE)
   // @Transient
    //private Set<Ccase> ccases = new HashSet<>();

    public Person() {}

    public Person(String CNP, String name, Date birthday, PersonStatus status) {
        this.cnp = CNP;
        this.name = name;
        this.birthday = birthday;
        this.personStatus = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String CNP) {
        this.cnp = CNP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public PersonStatus getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(PersonStatus personStatus) {
        this.personStatus = personStatus;
    }

    /*
    @Transient
    public Set<Ccase> getCcases() {
        return ccases;
    }

    public void setCcases(Set<Ccase> ccases) {
        this.ccases = ccases;
    }
    */
}
