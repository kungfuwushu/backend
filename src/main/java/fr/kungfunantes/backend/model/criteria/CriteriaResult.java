package fr.kungfunantes.backend.model.criteria;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
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
}
