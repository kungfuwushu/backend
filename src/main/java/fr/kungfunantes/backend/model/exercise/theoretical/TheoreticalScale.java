package fr.kungfunantes.backend.model.exercise.theoretical;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@ApiModel
@DiscriminatorValue(value = "THEORETICAL")
public class TheoreticalScale extends ExerciseScale {
  
    private int scale;

    @Override
    public ExerciseScale clone() {
        TheoreticalScale theoreticalScale = new TheoreticalScale();
        theoreticalScale.getScale();
        return super.clone(theoreticalScale);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TheoreticalScale))
            return false;
        TheoreticalScale theoricalScale = (TheoreticalScale) other;
        int scale =  theoricalScale.getScale();
        if (this.scale != scale)
            return false;
        return true;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
   
}
