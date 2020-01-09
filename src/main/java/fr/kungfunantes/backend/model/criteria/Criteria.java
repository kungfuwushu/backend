package fr.kungfunantes.backend.model.criteria;

import io.swagger.annotations.ApiModel;
import fr.kungfunantes.backend.model.exercise.taolu.Taolu;
import fr.kungfunantes.backend.model.exercise.ExerciseCriteria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    List<ExerciseCriteria> exerciseCriteria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
