package fr.kungfunantes.backend.model.result.exercise.type;

import fr.kungfunantes.backend.model.result.criteria.CriteriaResult;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class TaoluResult extends ExerciseResult {
    @OneToMany(mappedBy = "exerciseResult")
    private List<CriteriaResult> criteriaResults;
}
