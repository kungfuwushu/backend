package fr.kungfunantes.backend.model.exercise.fight;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import fr.kungfunantes.backend.model.round.RoundScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class FightScale extends ExerciseScale {
    @OneToMany(cascade = CascadeType.ALL)
    private List<RoundScale> roundsScales;
}
