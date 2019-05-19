package fr.kungfunantes.backend.model.test;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.Group;
import fr.kungfunantes.backend.model.test.program.ProgramTest;
import fr.kungfunantes.backend.model.test.rank.RankTest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RankTest.class, name = "RANK"),
        @JsonSubTypes.Type(value = ProgramTest.class, name = "PROGRAM"),
})
public abstract class Test {
    public enum Type {
        RANK,
        PROGRAM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String name;
    private String address;
    private String city;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_group",
            joinColumns = @JoinColumn(name = "testId"),
            inverseJoinColumns = @JoinColumn(name = "groupId")
    )
    private Set<Group> groups;
}
