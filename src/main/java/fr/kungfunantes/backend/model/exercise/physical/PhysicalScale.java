package fr.kungfunantes.backend.model.exercise.physical;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "PHYSICAL")
public class PhysicalScale extends ExerciseScale {
}
