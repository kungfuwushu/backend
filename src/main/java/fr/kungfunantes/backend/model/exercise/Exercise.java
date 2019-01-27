package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.*;
import fr.kungfunantes.backend.model.category.Category;
import fr.kungfunantes.backend.model.exercise.type.Physical;
import fr.kungfunantes.backend.model.exercise.type.Taolu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Taolu.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = Physical.class, name = "PHYSICAL")
})
public abstract class Exercise {
    public enum Type {
        PHYSICAL, TAOLU
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("categoryId")
    private Category category;
}
