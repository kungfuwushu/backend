package fr.kungfunantes.backend.model.test;

import com.fasterxml.jackson.annotation.*;
import fr.kungfunantes.backend.model.Group;
import fr.kungfunantes.backend.model.Member;
import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import fr.kungfunantes.backend.model.test.program.ProgramTestResult;
import fr.kungfunantes.backend.model.test.rank.RankTestResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import static fr.kungfunantes.backend.model.test.Test.Type.*;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RankTestResult.class, name = "RANK"),
        @JsonSubTypes.Type(value = ProgramTestResult.class, name = "PROGRAM"),
})
public abstract class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performerId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("performerId")
    private Member performer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performerGroupId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("performerGroupId")
    private Group performerGroup;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExerciseResult> exercisesResults;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testId", nullable = false)
    private Test test;

    public static TestResult create(Test test, Member performer, Group performerGroup) {
        TestResult testResult = null;
        if (test.getType() == RANK) {
            testResult = new RankTestResult();
            ((RankTestResult) testResult).setRank(performer.getRank());
        }
        else if (test.getType() == PROGRAM)
            testResult = new ProgramTestResult();

        if (testResult != null) {
            testResult.setTest(test);
            testResult.setPerformer(performer);
            testResult.setPerformerGroup(performerGroup);
        }
        return testResult;
    }
}
