package fr.kungfunantes.backend.model.exercise;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;

import fr.kungfunantes.backend.model.exercise.taolu.Taolu;
import fr.kungfunantes.backend.model.criteria.Criteria;

@Entity
@ApiModel
public class ExerciseCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "exerciseId")
    Taolu taolu;

    @ManyToOne
    @JoinColumn(name = "criteriaId")
    Criteria criteria;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }
}
