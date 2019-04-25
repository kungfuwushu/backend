package fr.kungfunantes.backend.model.rank.exercise;

import com.fasterxml.jackson.annotation.*;
import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.rank.Rank;
import fr.kungfunantes.backend.model.rank.exercise.type.RankFight;
import fr.kungfunantes.backend.model.rank.exercise.type.RankPhysical;
import fr.kungfunantes.backend.model.rank.exercise.type.RankTaolu;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RankTaolu.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = RankPhysical.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = RankFight.class, name = "FIGHT"),
})
public abstract class RankExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double coefficient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("rankId")
    private Rank rank;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "exerciseId", nullable = false)
    private Exercise exercise;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = Exercise.class)
    @JsonIdentityReference
    @JsonProperty(value = "exerciseId")
    public void setExerciseWithId(Exercise exercise) {
        this.exercise = exercise;
    }
}
