package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.CriteriaScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel
public class RoundScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CriteriaScale> criterionScales;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roundId", nullable = false)
    private Round round;
}
