package fr.kungfunantes.backend.model.test.rank;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kungfunantes.backend.model.Rank;
import fr.kungfunantes.backend.model.test.TestResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel
@DiscriminatorValue(value = "RANK")
public class RankTestResult extends TestResult {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rankId")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("rankId")
    @NotNull
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
