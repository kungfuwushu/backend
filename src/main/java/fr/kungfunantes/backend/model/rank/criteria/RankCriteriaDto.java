package fr.kungfunantes.backend.model.rank.criteria;

public class RankCriteriaDto {
    private Long id;
    private Integer maximumScore;
    private Long rankExerciseId;
    private Long criteriaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(Integer maximumScore) {
        this.maximumScore = maximumScore;
    }

    public Long getRankExerciseId() {
        return rankExerciseId;
    }

    public void setRankExerciseId(Long rankExerciseId) {
        this.rankExerciseId = rankExerciseId;
    }

    public Long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Long criteriaId) {
        this.criteriaId = criteriaId;
    }
}