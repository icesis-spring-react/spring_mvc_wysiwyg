package com.example.wysiwyg_asignacion2.objects;

public class TerminalProject {

    private String title;
    private int studentsQuantity;
    private String state;

    public TerminalProject() {
    }

    public TerminalProject(String title, int studentsQuantity, String state) {
        this.title = title;
        this.studentsQuantity = studentsQuantity;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
