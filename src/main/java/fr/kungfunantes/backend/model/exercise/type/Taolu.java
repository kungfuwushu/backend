package fr.kungfunantes.backend.model.exercise.type;

import fr.kungfunantes.backend.model.exercise.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class Taolu extends Exercise {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_criteria",
            joinColumns = @JoinColumn(name = "exerciseId"),
            inverseJoinColumns = @JoinColumn(name = "criteriaId")
    )
    private Set<Criteria> criterion;
}
