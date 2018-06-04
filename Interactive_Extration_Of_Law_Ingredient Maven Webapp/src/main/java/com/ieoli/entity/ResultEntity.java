package com.ieoli.entity;

public class ResultEntity {
    private Integer resultid;

    private Integer textid;

    private Integer modelid;

    private Boolean istrue;

    private Integer userid;

    private String label;

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public Integer getTextid() {
        return textid;
    }

    public void setTextid(Integer textid) {
        this.textid = textid;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public Boolean getIstrue() {
        return istrue;
    }

    public void setIstrue(Boolean istrue) {
        this.istrue = istrue;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}