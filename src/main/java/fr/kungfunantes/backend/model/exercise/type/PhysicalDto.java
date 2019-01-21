package fr.kungfunantes.backend.model.exercise.type;

import fr.kungfunantes.backend.model.exercise.ExerciseDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PhysicalDto extends ExerciseDto {
    @Enumerated(EnumType.STRING)
    private Physical.Objective objective;

    @Enumerated(EnumType.STRING)
    private Physical.MeasurementUnit measurementUnit;

    public Physical.Objective getObjective() {
        return objective;
    }

    public void setObjective(Physical.Objective objective) {
        this.objective = objective;
    }

    public Physical.MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(Physical.MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}