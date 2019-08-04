package fr.kungfunantes.backend.model.exercise.fight;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import fr.kungfunantes.backend.model.round.RoundScale;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@ApiModel
@DiscriminatorValue(value = "FIGHT")
public class FightScale extends ExerciseScale {
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RoundScale> roundsScales;

    @Override
    public ExerciseScale clone() {
        FightScale fightScale = new FightScale();
        fightScale.setRoundsScales(new ArrayList<>());
        for (RoundScale roundScale: roundsScales)
            fightScale.getRoundsScales().add(roundScale.clone());
        return super.clone(fightScale);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof FightScale))
            return false;
        FightScale fightScale = (FightScale) other;
        List<RoundScale> roundsScales =  fightScale.getRoundsScales();
        if (this.roundsScales.size() != roundsScales.size())
            return false;
        for (RoundScale roundScale: roundsScales) {
            Optional<RoundScale> opt = this.roundsScales.stream()
                    .filter(o -> o.getId().equals(roundScale.getId()))
                    .findFirst();
            if (!opt.isPresent() || !opt.get().equals(roundScale))
                return false;
        }
        return true;
    }

    public List<RoundScale> getRoundsScales() {
        return roundsScales;
    }

    public void setRoundsScales(List<RoundScale> roundsScales) {
        this.roundsScales = roundsScales;
    }
}
