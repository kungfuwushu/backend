package fr.kungfunantes.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

@Entity
@ApiModel(description = "A Profile is allowed to connect to the application")
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "Firstname should be between 2 characters and 30.")
    @Size(min = 2, message = "Firstname must be at least 2 characters")
    @Size(max = 30, message = "Firstname must be at most 30 characters")
    private String firstname;

    @ApiModelProperty(notes = "Lastname should be between 2 characters and 20.")
    @Size(max = 30, message = "Lastname must be at most 30 characters")
    private String lastname;

    @ApiModelProperty(notes = "Username must be at most 15 characters.")
    @NotBlank
    @Size(max = 15, message = "Username must be at most 15 characters")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("accountId")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Profile() {
        super();
    }

    public Profile(String firstname, String lastname, String username) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return account.getEmail();
    }

    public String getPassword() {
        return account.getPassword();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
