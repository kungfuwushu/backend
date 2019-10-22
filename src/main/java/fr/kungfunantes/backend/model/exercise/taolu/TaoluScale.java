package fr.kungfunantes.backend.model.exercise.taolu;

import fr.kungfunantes.backend.model.criteria.CriteriaScale;
import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class TaoluScale extends ExerciseScale {
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CriteriaScale> criterionScales;

    @Override
    public ExerciseScale clone() {
        TaoluScale exerciseScale = new TaoluScale();
        exerciseScale.setCriterionScales(new ArrayList<>());
        for (CriteriaScale criteriaScale: criterionScales)
            exerciseScale.getCriterionScales().add(criteriaScale.clone());
        return super.clone(exerciseScale);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TaoluScale))
            return false;
        TaoluScale taoluScale = (TaoluScale) other;
        List<CriteriaScale> criterionScales =  taoluScale.getCriterionScales();
        if (this.criterionScales.size() != criterionScales.size())
            return false;
        for (CriteriaScale criteriaScale: criterionScales) {
            Optional<CriteriaScale> opt = this.criterionScales.stream()
                    .filter(o -> o.getId().equals(criteriaScale.getId()))
                    .findFirst();
            if (!opt.isPresent() || !opt.get().equals(criteriaScale))
                return false;
        }
        return true;
    }

    public List<CriteriaScale> getCriterionScales() {
        return criterionScales;
    }

    public void setCriterionScales(List<CriteriaScale> criterionScales) {
        this.criterionScales = criterionScales;
    }
}
