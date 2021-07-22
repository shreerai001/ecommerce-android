package com.shree.ecom.activitySearch.model.dto;

public class SearchFilterEntity {
    private int id;
    private String name;
    private boolean checkbox;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
