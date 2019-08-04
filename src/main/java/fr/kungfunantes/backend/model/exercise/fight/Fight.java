package fr.kungfunantes.backend.model.exercise.fight;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.round.Round;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

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

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }
}
