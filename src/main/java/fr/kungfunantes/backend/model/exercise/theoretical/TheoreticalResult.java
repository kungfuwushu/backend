package fr.kungfunantes.backend.model.exercise.theoretical;

import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@ApiModel
@DiscriminatorValue(value = "THEORETICAL")
public class TheoreticalResult extends ExerciseResult {
    private int score;
    private String answer;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
