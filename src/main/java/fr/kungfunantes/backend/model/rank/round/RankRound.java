package fr.kungfunantes.backend.model.rank.round;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import fr.kungfunantes.backend.model.round.Round;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel
public class RankRound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankExerciseId", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = RankExercise.class)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(value = "rankExerciseId")
    private RankExercise rankExercise;

    @OneToMany(mappedBy = "rankRound")
    private List<RankCriteria> rankCriterion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roundId", nullable = false)
    private Round round;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = Criteria.class)
    @JsonIdentityReference
    @JsonProperty(value = "roundId")
    public void setRoundWithId(Round round) {
        this.round = round;
    }
}
