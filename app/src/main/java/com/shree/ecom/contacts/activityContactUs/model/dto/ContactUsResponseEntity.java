package com.shree.ecom.contacts.activityContactUs.model.dto;

/**
 * Created by shree on 16,May,2019
 */
public class ContactUsResponseEntity {
    private int id;
    private String msg;
    private boolean error;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
