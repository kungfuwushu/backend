package fr.kungfunantes.backend.model.rank.criteria;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class RankCriteria {
    @Id
    @GeneratedValue
    private Long id;
    private int maximumScore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankexercise_id", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankExercise.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(value = "rankExerciseId")
    private RankExercise rankExercise;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "criteria_id", nullable = false)
    private Criteria criteria;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = Criteria.class)
    @JsonIdentityReference
    @JsonProperty(value = "criteriaId")
    public void setCriteriaWithId(Criteria criteria) {
        this.criteria = criteria;
    }
}
