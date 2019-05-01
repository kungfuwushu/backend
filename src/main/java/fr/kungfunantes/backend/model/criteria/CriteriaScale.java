package fr.kungfunantes.backend.model.criteria;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class CriteriaScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int scale;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "criteriaId", nullable = false)
    private Criteria criteria;
}
