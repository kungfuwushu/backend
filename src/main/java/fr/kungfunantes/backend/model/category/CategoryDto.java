package fr.kungfunantes.backend.model.category;

import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Long parentId;
    private List<Long> subCategoriesId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Long> getSubCategoriesId() {
        return subCategoriesId;
    }

    public void setSubCategoriesId(List<Long> subCategoriesId) {
        this.subCategoriesId = subCategoriesId;
    }
}