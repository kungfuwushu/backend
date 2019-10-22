package fr.kungfunantes.backend.model.test;

import com.fasterxml.jackson.annotation.*;
import fr.kungfunantes.backend.model.Group;
import fr.kungfunantes.backend.model.Member;
import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import fr.kungfunantes.backend.model.test.program.ProgramTest;
import fr.kungfunantes.backend.model.test.program.ProgramTestResult;
import fr.kungfunantes.backend.model.test.rank.RankTest;
import fr.kungfunantes.backend.model.test.rank.RankTestResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@DiscriminatorColumn(name = "type")
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
        if (test instanceof RankTest) {
            testResult = new RankTestResult();
            ((RankTestResult) testResult).setRank(performer.getRank());
        }
        else if (test instanceof ProgramTest)
            testResult = new ProgramTestResult();

        if (testResult != null) {
            testResult.setTest(test);
            testResult.setPerformer(performer);
            testResult.setPerformerGroup(performerGroup);
        }
        return testResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getPerformer() {
        return performer;
    }

    public void setPerformer(Member performer) {
        this.performer = performer;
    }

    public Group getPerformerGroup() {
        return performerGroup;
    }

    public void setPerformerGroup(Group performerGroup) {
        this.performerGroup = performerGroup;
    }

    public List<ExerciseResult> getExercisesResults() {
        return exercisesResults;
    }

    public void setExercisesResults(List<ExerciseResult> exercisesResults) {
        this.exercisesResults = exercisesResults;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
