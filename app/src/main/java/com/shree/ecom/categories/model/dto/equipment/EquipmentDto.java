package com.shree.ecom.categories.model.dto.equipment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EquipmentDto {
    @Expose
    @SerializedName("subCategoryDto")
    private List<SubCategoryDto> subCategoryDto;
    @Expose
    @SerializedName("updated_at")
    private String updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("slug")
    private String slug;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("parent_id")
    private int parent_id;
    @Expose
    @SerializedName("id")
    private int id;

    public List<SubCategoryDto> getSubCategoryDto() {
        return subCategoryDto;
    }

    public void setSubCategoryDto(List<SubCategoryDto> subCategoryDto) {
        this.subCategoryDto = subCategoryDto;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
