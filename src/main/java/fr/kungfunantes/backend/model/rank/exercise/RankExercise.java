package fr.kungfunantes.backend.model.rank.exercise;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.rank.Rank;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class RankExercise {
    @Id
    @GeneratedValue
    private Long id;
    private double coefficient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public Rank getRank() {
        return rank;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
