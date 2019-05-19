package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.CriteriaResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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
}
