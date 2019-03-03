package fr.kungfunantes.backend.model.rank.exercise.type;

import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import fr.kungfunantes.backend.model.rank.round.RankRound;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class RankFight extends RankExercise {
    @OneToMany(mappedBy = "rankExercise")
    private List<RankRound> rankRounds;
}
