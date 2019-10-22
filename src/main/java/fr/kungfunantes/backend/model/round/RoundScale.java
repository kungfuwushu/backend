package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.CriteriaScale;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CriteriaScale> getCriterionScales() {
        return criterionScales;
    }

    public void setCriterionScales(List<CriteriaScale> criterionScales) {
        this.criterionScales = criterionScales;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
