package fr.kungfunantes.backend.model.exercise.taolu;

import fr.kungfunantes.backend.model.criteria.CriteriaScale;
import fr.kungfunantes.backend.model.exercise.ExerciseScale;
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
public class TaoluScale extends ExerciseScale {
    @OneToMany(cascade = CascadeType.ALL)
    private List<CriteriaScale> criterionScales;
}
