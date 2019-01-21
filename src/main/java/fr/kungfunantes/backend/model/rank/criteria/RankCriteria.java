package fr.kungfunantes.backend.model.rank.criteria;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class RankCriteria {
    @Id
    @GeneratedValue
    private Long id;
    private int maximumScore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankexercise_id", nullable = false)
    private RankExercise rankExercise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "criteria_id", nullable = false)
    private Criteria criteria;

    public Long getId() {
        return id;
    }

    public int getMaximumScore() {
        return maximumScore;
    }

    public RankExercise getRankExercise() {
        return rankExercise;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMaximumScore(int maximumScore) {
        this.maximumScore = maximumScore;
    }

    public void setRankExercise(RankExercise rankExercise) {
        this.rankExercise = rankExercise;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }
}
