package fr.kungfunantes.backend.model.exercise.fight;

import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import fr.kungfunantes.backend.model.round.RoundResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class FightResult extends ExerciseResult {
    @OneToMany(cascade = CascadeType.ALL)
    private List<RoundResult> roundsResults;
}
