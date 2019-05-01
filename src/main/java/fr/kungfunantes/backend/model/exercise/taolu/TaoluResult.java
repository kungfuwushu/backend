package fr.kungfunantes.backend.model.exercise.taolu;

import fr.kungfunantes.backend.model.criteria.CriteriaResult;
import fr.kungfunantes.backend.model.exercise.ExerciseResult;
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
@DiscriminatorValue(value = "TAOLU")
public class TaoluResult extends ExerciseResult {
    @OneToMany(cascade = CascadeType.ALL)
    private List<CriteriaResult> criterionResults;
}
