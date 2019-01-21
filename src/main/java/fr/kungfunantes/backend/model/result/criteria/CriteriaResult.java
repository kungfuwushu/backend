package fr.kungfunantes.backend.model.result.criteria;

import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class CriteriaResult {
    @Id
    @GeneratedValue
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exerciseresult_id", nullable = false)
    private ExerciseResult exerciseResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankcriteria_id", nullable = false)
    private RankCriteria rankCriteria;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public ExerciseResult getExerciseResult() {
        return exerciseResult;
    }

    public RankCriteria getRankCriteria() {
        return rankCriteria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setExerciseResult(ExerciseResult exerciseResult) {
        this.exerciseResult = exerciseResult;
    }

    public void setRankCriteria(RankCriteria rankCriteria) {
        this.rankCriteria = rankCriteria;
    }
}
