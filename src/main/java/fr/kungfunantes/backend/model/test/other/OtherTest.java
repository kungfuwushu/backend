package fr.kungfunantes.backend.model.test.other;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import fr.kungfunantes.backend.model.test.Test;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "OTHER")
public class OtherTest extends Test {
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("position ASC")
    private List<ExerciseScale> exercisesScales;
}
