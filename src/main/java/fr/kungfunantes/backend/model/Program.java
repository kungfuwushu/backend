package fr.kungfunantes.backend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Data
@Entity
@ApiModel
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type", visible = true)
@DiscriminatorColumn(name = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Program.class, name = "PROGRAM"),
        @JsonSubTypes.Type(value = Rank.class, name = "RANK"),
})
@DiscriminatorValue(value = "PROGRAM")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("position ASC")
    private List<ExerciseScale> exercisesScales;
}
