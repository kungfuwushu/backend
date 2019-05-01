package fr.kungfunantes.backend.model.exercise.physical;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "PHYSICAL")
public class PhysicalScale extends ExerciseScale {
    @Override
    public ExerciseScale clone() {
        return super.clone(new PhysicalScale());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhysicalScale))
            return false;
        return true;
    }
}
