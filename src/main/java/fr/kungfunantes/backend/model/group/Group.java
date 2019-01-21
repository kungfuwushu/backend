package fr.kungfunantes.backend.model.group;

import fr.kungfunantes.backend.model.member.Member;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Member> members;

    public Long getId() {
        return id;
    }

    public List<Member> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
