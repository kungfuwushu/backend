package fr.kungfunantes.backend.model.rank.exercise.type;

import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
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
public class RankPhysical extends RankExercise {
}
