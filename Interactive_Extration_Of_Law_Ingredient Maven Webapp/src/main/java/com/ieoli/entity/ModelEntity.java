package com.ieoli.entity;

public class ModelEntity {
    private Integer modelid;

    private String modeldescription;

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public String getModeldescription() {
        return modeldescription;
    }

    public void setModeldescription(String modeldescription) {
        this.modeldescription = modeldescription == null ? null : modeldescription.trim();
    }
}