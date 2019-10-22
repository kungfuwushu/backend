package fr.kungfunantes.backend.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@ApiModel
@DiscriminatorValue(value = "RANK")
public class Rank extends Program {
    private String image;
    private int position;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
