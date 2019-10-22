package fr.kungfunantes.backend.model.criteria;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class CriteriaResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "criteriaScaleId", nullable = false)
    private CriteriaScale criteriaScale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public CriteriaScale getCriteriaScale() {
        return criteriaScale;
    }

    public void setCriteriaScale(CriteriaScale criteriaScale) {
        this.criteriaScale = criteriaScale;
    }
}
