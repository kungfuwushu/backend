package fr.kungfunantes.backend.model.evaluation;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.group.Group;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ApiModel
public class Evaluation {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String address;
    private String city;
    private String postalCode;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "evaluation_exercise",
        joinColumns = @JoinColumn(name = "evaluation_id"),
        inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    @OrderColumn(name = "exercise_order")
    private List<Exercise> exercises;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "evaluation_group",
            joinColumns = @JoinColumn(name = "evaluation_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @OrderColumn(name = "group_order")
    private List<Group> groups;
}
