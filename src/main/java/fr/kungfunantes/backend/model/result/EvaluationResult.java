package fr.kungfunantes.backend.model.result;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kungfunantes.backend.model.evaluation.Evaluation;
import fr.kungfunantes.backend.model.group.Group;
import fr.kungfunantes.backend.model.member.Member;
import fr.kungfunantes.backend.utils.EntityIdResolver;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel
public class EvaluationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performer_id", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("performerId")
    private Member performer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performergroup_id", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("performerGroupId")
    private Group performerGroup;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluation_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Evaluation evaluation;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = EntityIdResolver.class,
            scope = Evaluation.class)
    @JsonIdentityReference
    @JsonProperty(value = "evaluationId", required = true)
    public void setEvaluationWithId(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
