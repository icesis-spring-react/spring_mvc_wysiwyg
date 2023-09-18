package com.example.wysiwyg_asignacion2.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Professor {

    private String fullName;
    private String academicGrade;
    private String username;
    private String password;

    private List<ResearchArticle> articles = new ArrayList<>();
    private List<TerminalProject> projects = new ArrayList<>();

    public Professor() {
    }

    public Professor(String fullName, String academicGrade, String username, String password) {
        this.fullName = fullName;
        this.academicGrade = academicGrade;
        this.username = username;
        this.password = password;
    }

    public Professor(String fullName, String academicGrade, String username, String password, List<ResearchArticle> articles, List<TerminalProject> projects) {
        this.fullName = fullName;
        this.academicGrade = academicGrade;
        this.username = username;
        this.password = password;
        this.articles = articles;
        this.projects = projects;
    }

    public boolean addArticle(ResearchArticle article) {
        return articles.add(article);
    }

    public boolean addProject(TerminalProject project) {
        return projects.add(project);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAcademicGrade() {
        return academicGrade;
    }

    public void setAcademicGrade(String academicGrade) {
        this.academicGrade = academicGrade;
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
