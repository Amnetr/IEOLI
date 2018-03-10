package com.ieoli.entity;

public class TextEntity {
    private Integer textid;

    private Integer modelid;

    private String textname;

    private String article;

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

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname == null ? null : textname.trim();
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article == null ? null : article.trim();
    }
}