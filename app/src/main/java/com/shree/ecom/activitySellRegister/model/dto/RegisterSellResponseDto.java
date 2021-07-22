package com.shree.ecom.activitySellRegister.model.dto;

public class RegisterSellResponseDto {
    private int id;
    private String sucess;
    private boolean error;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSucess() {
        return sucess;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}