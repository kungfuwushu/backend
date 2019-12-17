package fr.kungfunantes.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "A Profile is allowed to connect to the application")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "First name should be between 2 characters and 30.")
    @Size(min = 2, message = "First name must be at least 2 characters")
    @Size(max = 30, message = "First name must be at most 30 characters")
    private String firstName;

    @ApiModelProperty(notes = "Last name should be between 2 characters and 20.")
    @Size(max = 30, message = "Last name must be at most 30 characters")
    private String lastName;

    @ApiModelProperty(notes = "Username must be at most 15 characters.")
    @NotBlank
    @Size(max = 15, message = "Username must be at most 15 characters")
    private String username;

    @NaturalId
    @Size(max = 80, message = "Email must be at most 80 characters")
    @Email
    private String email;

    @NotBlank
    @Size(min = 10, message = "Password hash must be at least 10 characters")
    @Size(max = 100, message = "Password hash must be at most 100 characters")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Profile() {
        super();
    }

    public Profile(String firstName, String lastName, String username, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
