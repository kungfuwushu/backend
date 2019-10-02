package fr.kungfunantes.backend.model.criteria;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class CriteriaScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer scale;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "criteriaId", nullable = false)
    private Criteria criteria;

    @Override
    public CriteriaScale clone() {
        CriteriaScale criteriaScale = new CriteriaScale();
        criteriaScale.setScale(scale);
        criteriaScale.setCriteria(criteria);
        return criteriaScale;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CriteriaScale))
            return false;
        CriteriaScale criteriaScale = (CriteriaScale) o;
        return scale == criteriaScale.getScale();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }
}
