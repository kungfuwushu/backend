package fr.kungfunantes.backend.model.exercise.theoretical;

import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
@DiscriminatorValue(value = "THEORETICAL")
public class Theoretical extends Exercise {
    private String question;
    private String reponse;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getType() {
      return "THEORETICAL";
    }
}
