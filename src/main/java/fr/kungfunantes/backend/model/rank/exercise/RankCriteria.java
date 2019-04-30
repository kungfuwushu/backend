package fr.kungfunantes.backend.model.rank.exercise;

import fr.kungfunantes.backend.model.exercise.Criteria;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class RankCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int maximumScore;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "criteriaId", nullable = false)
    private Criteria criteria;
}
