package fr.kungfunantes.backend.model.exercise;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import fr.kungfunantes.backend.model.Category;
import fr.kungfunantes.backend.model.exercise.fight.Fight;
import fr.kungfunantes.backend.model.exercise.physical.Physical;
import fr.kungfunantes.backend.model.exercise.taolu.Taolu;
import fr.kungfunantes.backend.model.exercise.theoretical.Theoretical;

import io.swagger.annotations.ApiModel;
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type", visible = true)
@DiscriminatorColumn(name = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Taolu.class, name = "TAOLU"),
        @JsonSubTypes.Type(value = Physical.class, name = "PHYSICAL"),
        @JsonSubTypes.Type(value = Fight.class, name = "FIGHT"),
        @JsonSubTypes.Type(value = Theoretical.class, name = "THEORETICAL"),
})
public abstract class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public abstract String getType();
}
