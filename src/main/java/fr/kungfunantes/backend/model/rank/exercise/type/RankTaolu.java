package fr.kungfunantes.backend.model.rank.exercise.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @OneToMany(mappedBy = "rankExercise")
    @JsonIgnore
    private List<RankCriteria> rankCriterias;
}
