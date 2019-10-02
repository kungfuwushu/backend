package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.fight.FightResult;
import fr.kungfunantes.backend.model.exercise.physical.PhysicalResult;
import fr.kungfunantes.backend.model.exercise.taolu.TaoluResult;
import fr.kungfunantes.backend.model.exercise.theoretical.TheoreticalResult;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type", visible = true)
@DiscriminatorColumn(name = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TaoluResult.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = PhysicalResult.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = FightResult.class, name = "FIGHT"),
        @JsonSubTypes.Type(value = TheoreticalResult.class, name = "THEORETICAL"),
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ExerciseScale getExerciseScale() {
        return exerciseScale;
    }

    public void setExerciseScale(ExerciseScale exerciseScale) {
        this.exerciseScale = exerciseScale;
    }
}
