package fr.kungfunantes.backend.model.exercise;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
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
}
