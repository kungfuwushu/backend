package fr.kungfunantes.backend.model.result.evaluation;

import fr.kungfunantes.backend.model.evaluation.Evaluation;
import fr.kungfunantes.backend.model.group.Group;
import fr.kungfunantes.backend.model.member.Member;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@ApiModel
public class EvaluationResult {
    @Id
    @GeneratedValue
    private Long id;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performer_id", nullable = false)
    private Member performer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluation_id", nullable = false)
    private Evaluation evaluation;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public Member getPerformer() {
        return performer;
    }

    public Group getGroup() {
        return group;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPerformer(Member performer) {
        this.performer = performer;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
