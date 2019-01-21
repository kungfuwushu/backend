package fr.kungfunantes.backend.model.exercise.type;

import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@ApiModel
@DiscriminatorValue(value = "PHYSICAL")
public class Physical extends Exercise {
    public enum Objective {
        MINIMUM,
        MAXIMUM,
    }

    public enum MeasurementUnit {
        METER,
        SECOND,
    }

    @Enumerated(EnumType.STRING)
    private Objective objective;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
