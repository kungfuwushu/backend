package fr.kungfunantes.backend.model.result.exercise;

import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import fr.kungfunantes.backend.model.result.evaluation.EvaluationResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ExerciseResult {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluationResult_id", nullable = false)
    private EvaluationResult evaluationResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankExercise_id", nullable = false)
    private RankExercise rankExercise;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public EvaluationResult getEvaluationResult() {
        return evaluationResult;
    }

    public RankExercise getRankExercise() {
        return rankExercise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEvaluationResult(EvaluationResult evaluationResult) {
        this.evaluationResult = evaluationResult;
    }

    public void setRankExercise(RankExercise rankExercise) {
        this.rankExercise = rankExercise;
    }
}
