package fr.kungfunantes.backend.model.round;

import fr.kungfunantes.backend.model.criteria.Criteria;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@ApiModel
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "round_criteria",
            joinColumns = @JoinColumn(name = "roundId"),
            inverseJoinColumns = @JoinColumn(name = "criteriaId")
    )
    private Set<Criteria> criterion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Criteria> getCriterion() {
        return criterion;
    }

    public void setCriterion(Set<Criteria> criterion) {
        this.criterion = criterion;
    }
}
