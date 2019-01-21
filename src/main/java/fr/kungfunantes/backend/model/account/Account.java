package fr.kungfunantes.backend.model.account;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class Account {

    public enum AccountPrivilege {
        TEACHER, NONE
    }

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private AccountPrivilege privilege;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public AccountPrivilege getPrivilege() {
        return privilege;
    }
}
