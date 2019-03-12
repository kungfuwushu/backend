package fr.kungfunantes.backend.model.evaluation;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.group.Group;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@ApiModel
public class Evaluation {
    public enum Type {
        RANK,
        OTHER
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "evaluation_exercise",
        joinColumns = @JoinColumn(name = "evaluationId"),
        inverseJoinColumns = @JoinColumn(name = "exerciseId")
    )
    private Set<Exercise> exercises;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "evaluation_group",
            joinColumns = @JoinColumn(name = "evaluationId"),
            inverseJoinColumns = @JoinColumn(name = "groupId")
    )
    private Set<Group> groups;
}
