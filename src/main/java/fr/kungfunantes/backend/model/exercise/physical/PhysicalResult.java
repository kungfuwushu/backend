package fr.kungfunantes.backend.model.exercise.physical;

import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "PHYSICAL")
public class PhysicalResult extends ExerciseResult {
    private int score;
}
