package com.example.wysiwyg_asignacion2.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Professor {

    private String name;
    private String academicGrade;
    private String username;
    private String password;

    private List<ResearchArticle> articles = new ArrayList<>();
    private List<TerminalProject> projects = new ArrayList<>();

    public Professor() {
    }

    public Professor(String name, String academicGrade, String username, String password) {
        this.name = name;
        this.academicGrade = academicGrade;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicGrade() {
        return academicGrade;
    }

    public void setAcademicGrade(String academicGrade) {
        this.academicGrade = academicGrade;
    }

    public List<ResearchArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<ResearchArticle> articles) {
        this.articles = articles;
    }

    public List<TerminalProject> getProjects() {
        return projects;
    }

    public void setProjects(List<TerminalProject> projects) {
        this.projects = projects;
    }
}
