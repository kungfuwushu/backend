package fr.kungfunantes.backend.model.test.rank;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kungfunantes.backend.model.Rank;
import fr.kungfunantes.backend.model.test.TestResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "RANK")
public class RankTestResult extends TestResult {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("rankId")
    private Rank rank;
}
