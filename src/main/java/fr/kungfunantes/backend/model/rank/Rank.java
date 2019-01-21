package fr.kungfunantes.backend.model.rank;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ApiModel
public class Rank {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int maximumScore;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaximumScore() {
        return maximumScore;
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

    public void setMaximumScore(int maximumScore) {
        this.maximumScore = maximumScore;
    }
}
