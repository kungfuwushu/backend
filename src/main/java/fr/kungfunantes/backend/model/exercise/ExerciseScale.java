package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.fight.FightScale;
import fr.kungfunantes.backend.model.exercise.physical.PhysicalScale;
import fr.kungfunantes.backend.model.exercise.taolu.TaoluScale;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type", visible = true)
@DiscriminatorColumn(name = "type")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "newestVersionId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("newestVersionId")
    private ExerciseScale newestVersion;

    public abstract ExerciseScale clone();

    public ExerciseScale clone(ExerciseScale exerciseScale) {
        exerciseScale.setExercise(exercise);
        exerciseScale.setPosition(position);
        return exerciseScale;
    }

    @Override
    public abstract boolean equals(Object o);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public ExerciseScale getNewestVersion() {
        return newestVersion;
    }

    public void setNewestVersion(ExerciseScale newestVersion) {
        this.newestVersion = newestVersion;
    }
}
