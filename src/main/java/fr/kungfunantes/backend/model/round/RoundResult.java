package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.CriteriaResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
public class RoundResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CriteriaResult> criterionResults;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roundScaleId", nullable = false)
    private RoundScale roundScale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CriteriaResult> getCriterionResults() {
        return criterionResults;
    }

    public void setCriterionResults(List<CriteriaResult> criterionResults) {
        this.criterionResults = criterionResults;
    }

    public RoundScale getRoundScale() {
        return roundScale;
    }

    public void setRoundScale(RoundScale roundScale) {
        this.roundScale = roundScale;
    }
}
