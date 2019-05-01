package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.CriteriaScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@ApiModel
public class RoundScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CriteriaScale> criterionScales;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roundId", nullable = false)
    private Round round;

    public RoundScale clone() {
        RoundScale roundScale = new RoundScale();
        roundScale.setCriterionScales(new ArrayList<>());
        for (CriteriaScale criteriaScale: criterionScales)
            roundScale.getCriterionScales().add(criteriaScale.clone());
        roundScale.setRound(round);
        return roundScale;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof RoundScale))
            return false;
        RoundScale roundScale = (RoundScale) other;
        List<CriteriaScale> criterionScales =  roundScale.getCriterionScales();
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
}
