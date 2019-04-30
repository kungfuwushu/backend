package fr.kungfunantes.backend.model.rank.exercise.type;

import fr.kungfunantes.backend.model.rank.exercise.RankCriteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
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
@DiscriminatorValue(value = "TAOLU")
public class RankTaolu extends RankExercise {
    @OneToMany(cascade = CascadeType.ALL)
    private List<RankCriteria> rankCriterion;
}
