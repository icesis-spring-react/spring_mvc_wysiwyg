package com.example.wysiwyg_asignacion2.objects;

public class ResearchArticle {

    private String title;
    private String state;
    private Magazine magazine;

    public ResearchArticle() {
    }

    public ResearchArticle(String title, String state, Magazine magazine) {
        this.title = title;
        this.state = state;
        this.magazine = magazine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}
