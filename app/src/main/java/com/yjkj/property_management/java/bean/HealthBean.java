package com.yjkj.property_management.java.bean;

public class HealthBean {

    public String title = "";

    public String value = "";

    public int status;

    public HealthBean(String a, String b, int c){
        this.title = a;
        this.value = b;
        this.status = c;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
