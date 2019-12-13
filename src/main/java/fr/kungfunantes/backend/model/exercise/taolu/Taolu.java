package fr.kungfunantes.backend.model.exercise.taolu;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.exercise.ExerciseCriteria;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class Taolu extends Exercise {
    @OneToMany
    List<ExerciseCriteria> exerciseCriteria;

    public String getType() {
      return "TAOLU";
    }
}
