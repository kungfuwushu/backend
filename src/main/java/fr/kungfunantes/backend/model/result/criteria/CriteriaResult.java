package fr.kungfunantes.backend.model.result.criteria;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class CriteriaResult {
    @Id
    @GeneratedValue
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exerciseresult_id", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = ExerciseResult.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("exerciseResultId")
    private ExerciseResult exerciseResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankcriteria_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private RankCriteria rankCriteria;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankCriteria.class)
    @JsonIdentityReference
    @JsonProperty(value = "rankCriteriaId", required = true)
    public void setRankCriteriaWithId(RankCriteria rankCriteria) {
        this.rankCriteria = rankCriteria;
    }
}
