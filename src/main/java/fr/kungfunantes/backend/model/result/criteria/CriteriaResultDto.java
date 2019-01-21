package fr.kungfunantes.backend.model.result.criteria;

public class CriteriaResultDto {
    private Long id;
    private Integer score;
    private Long exerciseResultId;
    private Long rankCriteriaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getExerciseResultId() {
        return exerciseResultId;
    }

    public void setExerciseResultId(Long exerciseResultId) {
        this.exerciseResultId = exerciseResultId;
    }

    public Long getRankCriteriaId() {
        return rankCriteriaId;
    }

    public void setRankCriteriaId(Long rankCriteriaId) {
        this.rankCriteriaId = rankCriteriaId;
    }
}