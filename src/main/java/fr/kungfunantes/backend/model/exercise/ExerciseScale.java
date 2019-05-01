package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.fight.FightScale;
import fr.kungfunantes.backend.model.exercise.physical.PhysicalScale;
import fr.kungfunantes.backend.model.exercise.taolu.TaoluScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TaoluScale.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = PhysicalScale.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = FightScale.class, name = "FIGHT"),
})
public abstract class ExerciseScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int position;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "exerciseId", nullable = false)
    private Exercise exercise;
}
