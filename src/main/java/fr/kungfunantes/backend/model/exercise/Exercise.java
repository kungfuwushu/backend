package fr.kungfunantes.backend.model.exercise;

import fr.kungfunantes.backend.model.category.Category;
import fr.kungfunantes.backend.model.evaluation.Evaluation;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    @JoinColumn(name = "group_id", nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
