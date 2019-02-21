package fr.kungfunantes.backend.model.exercise.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class Taolu extends Exercise {
    @OneToMany(mappedBy = "exercise")
    @JsonIgnore
    private List<Criteria> criterias;
}
