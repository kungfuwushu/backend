package fr.kungfunantes.backend.model.exercise.type;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class Taolu extends Exercise {
    @OneToMany(mappedBy = "exercise")
    private List<Criteria> criterias;

    public List<Criteria> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<Criteria> criterias) {
        this.criterias = criterias;
    }
}
