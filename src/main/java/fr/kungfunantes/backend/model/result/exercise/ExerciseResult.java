package fr.kungfunantes.backend.model.result.exercise;

import com.fasterxml.jackson.annotation.*;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import fr.kungfunantes.backend.model.result.EvaluationResult;
import fr.kungfunantes.backend.model.result.exercise.type.PhysicalResult;
import fr.kungfunantes.backend.model.result.exercise.type.TaoluResult;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TaoluResult.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = PhysicalResult.class, name = "PHYSICAL")
})
public abstract class ExerciseResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluationResult_id", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = EvaluationResult.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("evaluationResultId")
    private EvaluationResult evaluationResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankExercise_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private RankExercise rankExercise;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankExercise.class)
    @JsonIdentityReference
    @JsonProperty(value = "rankExerciseId", required = true)
    public void setRankExerciseWithId(RankExercise rankExercise) {
        this.rankExercise = rankExercise;
    }
}
