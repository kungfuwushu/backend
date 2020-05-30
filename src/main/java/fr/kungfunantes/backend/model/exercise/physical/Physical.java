package fr.kungfunantes.backend.model.exercise.physical;

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
    public enum MeasurementUnit {
        METER,
        CENTIMETER,
        SECOND,
        MINUTE
    }

    private String objective;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getType() {
      return "PHYSICAL";
    }
}
