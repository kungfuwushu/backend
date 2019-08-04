package fr.kungfunantes.backend.model.exercise.physical;

import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@ApiModel
@DiscriminatorValue(value = "PHYSICAL")
public class PhysicalResult extends ExerciseResult {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
