package fr.kungfunantes.backend.model.member;

import fr.kungfunantes.backend.model.account.Account;
import fr.kungfunantes.backend.model.group.Group;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@ApiModel
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date birthdate;
    private String motivation;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getImage() {
        return image;
    }

    public Account getAccount() {
        return account;
    }

    public Group getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
