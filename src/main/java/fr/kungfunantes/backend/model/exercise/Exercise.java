package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.Category;
import fr.kungfunantes.backend.model.exercise.fight.Fight;
import fr.kungfunantes.backend.model.exercise.physical.Physical;
import fr.kungfunantes.backend.model.exercise.taolu.Taolu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type", visible = true)
@DiscriminatorColumn(name = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Taolu.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = Physical.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = Fight.class, name = "FIGHT"),
})
public abstract class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("categoryId")
    private Category category;
}
