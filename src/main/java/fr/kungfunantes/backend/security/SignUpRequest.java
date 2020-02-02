package fr.kungfunantes.backend.security;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(max = 30)
    private String firstname;

    @NotBlank
    @Size(max = 30)
    private String lastname;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NotBlank
    @Size(max = 80)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String name) {
        this.firstname = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String name) {
        this.lastname = name;
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
}
