package fr.kungfunantes.backend.model.exercise.type;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.exercise.Round;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class Fight extends Exercise {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_round",
            joinColumns = @JoinColumn(name = "exerciseId"),
            inverseJoinColumns = @JoinColumn(name = "roundId")
    )
    private Set<Round> rounds;
}
