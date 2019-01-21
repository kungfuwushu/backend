package fr.kungfunantes.backend.model.exercise;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.type.PhysicalDto;
import fr.kungfunantes.backend.model.exercise.type.TaoluDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PhysicalDto.class, name = "PHYSICAL"),
    @JsonSubTypes.Type(value = TaoluDto.class, name = "TAOLU")
})
public abstract class ExerciseDto {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    private Exercise.Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Exercise.Type getType() {
        return type;
    }

    public void setType(Exercise.Type type) {
        this.type = type;
    }
}