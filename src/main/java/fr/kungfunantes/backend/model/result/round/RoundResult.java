package fr.kungfunantes.backend.model.result.round;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.rank.round.RankRound;
import fr.kungfunantes.backend.model.result.criteria.CriteriaResult;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel
public class RoundResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseResultId")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = ExerciseResult.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(value = "exerciseResultId")
    private ExerciseResult exerciseResult;

    @OneToMany(mappedBy = "roundResult")
    private List<CriteriaResult> criteriaResults;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rankRoundId", nullable = false)
    private RankRound rankRound;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankRound.class)
    @JsonIdentityReference
    @JsonProperty(value = "rankRoundId")
    public void setRankRoundWithId(RankRound rankRound) {
        this.rankRound = rankRound;
    }
}
