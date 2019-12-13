package fr.kungfunantes.backend.model.exercise.fight;

import fr.kungfunantes.backend.model.exercise.ExerciseRound;
import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class Fight extends Exercise {
    @OneToMany
    List<ExerciseRound> exerciseRound;

    public String getType() {
      return "FIGHT";
    }
}
