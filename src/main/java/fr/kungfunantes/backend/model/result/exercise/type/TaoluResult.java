package fr.kungfunantes.backend.model.result.exercise.type;

import fr.kungfunantes.backend.model.result.criteria.CriteriaResult;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class TaoluResult extends ExerciseResult {
    @OneToMany(mappedBy = "exerciseResult")
    private List<CriteriaResult> criteriaResults;

    public List<CriteriaResult> getCriteriaResults() {
        return criteriaResults;
    }

    public void setCriteriaResults(List<CriteriaResult> criteriaResults) {
        this.criteriaResults = criteriaResults;
    }
}
