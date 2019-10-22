package fr.kungfunantes.backend.model.exercise.taolu;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class Taolu extends Exercise {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_criteria",
            joinColumns = @JoinColumn(name = "exerciseId"),
            inverseJoinColumns = @JoinColumn(name = "criteriaId")
    )
    private Set<Criteria> criterion;

    public Set<Criteria> getCriterion() {
        return criterion;
    }

    public void setCriterion(Set<Criteria> criterion) {
        this.criterion = criterion;
    }
}
