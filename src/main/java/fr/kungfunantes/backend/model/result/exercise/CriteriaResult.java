package fr.kungfunantes.backend.model.result.exercise;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.rank.exercise.RankCriteria;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class CriteriaResult {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roundResultId")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RoundResult.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(value = "roundResultId")
    private RoundResult roundResult;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rankCriteriaId", nullable = false)
    private RankCriteria rankCriteria;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankCriteria.class)
    @JsonIdentityReference
    @JsonProperty(value = "rankCriteriaId")
    public void setRankCriteriaWithId(RankCriteria rankCriteria) {
        this.rankCriteria = rankCriteria;
    }
}
