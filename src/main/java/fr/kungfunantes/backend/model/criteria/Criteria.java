package fr.kungfunantes.backend.model.criteria;

import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class Criteria {
    @Id
    @GeneratedValue
    private Long id;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "taolu_id", nullable = false)
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

}
