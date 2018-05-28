package dto;

import java.util.*;

public class PersonDto {

    private long id;
    private String CNP;
    private String name;
    private Date birthday;
    private String status;

    public PersonDto() {}

    public PersonDto(String CNP, String name, Date birthday, String status) {
        this.CNP = CNP;
        this.name = name;
        this.birthday = birthday;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
