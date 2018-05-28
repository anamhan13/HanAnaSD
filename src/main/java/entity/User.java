package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String username;
    private String password;
    private String name;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Role role;


   // @JsonIgnore
   // @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users",cascade = CascadeType.ALL)
    /*
    @ManyToMany()
   @JoinTable(name = "user_cases",
           joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"))
   */
   // @Transient
   // private Set<Ccase> ccases = new HashSet<>();

    public User() {}

    public User(String username, String password, String name, Date birthday, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /*
    @Transient
    public Set<Ccase> getCcases() {
        return ccases;
    }

    public void setCases(Set<Ccase> ccases) {
        this.ccases = ccases;
    }
    */
}
