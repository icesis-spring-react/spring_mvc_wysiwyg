package com.example.wysiwyg_asignacion2.objects;

public class TerminalProject {

    private String title;
    private String studensQuantity;
    private String state;

    public TerminalProject() {
    }

    public TerminalProject(String title, String studensQuantity, String state) {
        this.title = title;
        this.studensQuantity = studensQuantity;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudensQuantity() {
        return studensQuantity;
    }

    public void setStudensQuantity(String studensQuantity) {
        this.studensQuantity = studensQuantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
