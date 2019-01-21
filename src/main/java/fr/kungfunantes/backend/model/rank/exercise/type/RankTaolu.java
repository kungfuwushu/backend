package fr.kungfunantes.backend.model.rank.exercise.type;

import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.rank.exercise.RankExercise;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@ApiModel
@DiscriminatorValue(value = "TAOLU")
public class RankTaolu extends RankExercise {
    @OneToMany(mappedBy = "rankExercise")
    private List<RankCriteria> rankCriterias;

    public List<RankCriteria> getRankCriterias() {
        return rankCriterias;
    }

    public void setRankCriterias(List<RankCriteria> rankCriterias) {
        this.rankCriterias = rankCriterias;
    }
}
