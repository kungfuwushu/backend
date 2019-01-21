package fr.kungfunantes.backend.model.result.exercise;

import java.util.Date;

public abstract class ExerciseResultDto {
    private Long id;
    private Date date;
    private Integer score;
    private Long evaluationResultId;
    private Long rankExerciseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getEvaluationResultId() {
        return evaluationResultId;
    }

    public void setEvaluationResultId(Long evaluationResultId) {
        this.evaluationResultId = evaluationResultId;
    }

    public Long getRankExerciseId() {
        return rankExerciseId;
    }

    public void setRankExerciseId(Long rankExerciseId) {
        this.rankExerciseId = rankExerciseId;
    }
}