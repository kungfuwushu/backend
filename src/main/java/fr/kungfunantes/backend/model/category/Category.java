package fr.kungfunantes.backend.model.category;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "group_id", nullable = true)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> subCategories;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getParent() {
        return parent;
    }

    public List<Category> getSubCategories() {
        return subCategories;
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

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

}
