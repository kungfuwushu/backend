package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.fight.FightResult;
import fr.kungfunantes.backend.model.exercise.physical.PhysicalResult;
import fr.kungfunantes.backend.model.exercise.taolu.TaoluResult;
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
        @JsonSubTypes.Type(value = PhysicalResult.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = FightResult.class, name = "FIGHT")
})
public abstract class ExerciseResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private Date modifiedDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "exerciseScaleId", nullable = false)
    private ExerciseScale exerciseScale;
}
