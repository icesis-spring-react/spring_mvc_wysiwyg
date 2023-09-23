package com.example.wysiwyg_asignacion2.controllers;

import com.example.wysiwyg_asignacion2.AppConfig;
import com.example.wysiwyg_asignacion2.objects.Magazine;
import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.objects.ResearchArticle;
import com.example.wysiwyg_asignacion2.objects.TerminalProject;
import com.example.wysiwyg_asignacion2.services.ProfessorManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Objects;

@Controller
public class ProfessorController {

    ProfessorManagerService services;

    @RequestMapping(value = "/profLogin")
    public ModelAndView showLogin() {
        Professor professor = new Professor();

        ModelAndView model = new ModelAndView("login");
        model.addObject("professorForm", professor);

        return model;
    }

    @RequestMapping(value = "/loginProfessor")
    public ModelAndView login(@ModelAttribute("professorForm") Professor professor) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        services = (ProfessorManagerService) ctx.getBean("professorServices");

        boolean loginResult = services.loginProfessor(professor);

        if (loginResult) {
            ModelAndView model = new ModelAndView("welcome");

            professor = services.getProfessor(professor);

            model.addObject("professor", professor);

            return model;
        }

        return new ModelAndView("redirect:/profLogin");
    }

    @RequestMapping(value = "/showAddArticle")
    public ModelAndView showAddArticle(@ModelAttribute("professor") Professor professor) {
        ResearchArticle article = new ResearchArticle();

        Professor finalProfessor = professor;
        professor = services.getProfessors().stream().filter(prof -> Objects.equals(prof.getFullName(), finalProfessor.getFullName())).findFirst().orElse(null);

        ArrayList<Magazine> magazines = services.getMagazines();

        ModelAndView model = new ModelAndView("add-article");
        model.addObject("professorForm", professor);
        model.addObject("articleForm", article);
        model.addObject("magazines", magazines);

        return model;
    }

    @RequestMapping(value = "/addArticle")
    public ModelAndView addArticle(@ModelAttribute("articleForm") ResearchArticle article/*,
                                   @ModelAttribute("professor") Professor professor*/) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        services = (ProfessorManagerService) ctx.getBean("professorServices");

        Magazine magazine = services.getMagazines().stream().filter(mag -> Objects.equals(mag.getIsbn(), article.getMagazine().getIsbn())).findFirst().orElse(null);
        article.setMagazine(magazine);

        Professor professor = services.getProfessors().stream().filter(prof -> Objects.equals(prof.getFullName(), article.getAuthor().getFullName())).findFirst().orElse(null);

        services.addArticle(professor, article);

        System.out.println("Datos del artículo:" +
                "\nTítulo: " + article.getTitle() +
                "\nRevista: " + article.getMagazine().getTitle() +
                "\nEstado: " + article.getState());

        return new ModelAndView("redirect:/showAddArticle");
    }

    @RequestMapping(value = "/showAddMagazine")
    public ModelAndView showAddMagazine(@ModelAttribute("articleForm") ResearchArticle article) {
        Magazine magazine = new Magazine();

        ModelAndView model = new ModelAndView("add-magazine");
        model.addObject("magazineForm", magazine);
        model.addObject("articleForm", article);

        return model;
    }

    @RequestMapping(value = "/addMagazine")
    public ModelAndView addMagazine(@ModelAttribute("magazineForm") Magazine magazine) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        services = (ProfessorManagerService) ctx.getBean("professorServices");

        services.addMagazine(magazine);

        System.out.println("Datos de la revista:" +
                "\nTítulo: " + magazine.getTitle() +
                "\nISBN: " + magazine.getIsbn() +
                "\nTipo: " + magazine.getType());

        return new ModelAndView("redirect:/showAddMagazine");
    }

    @RequestMapping(value = "/showAddProject")
    public ModelAndView showAddProject(@ModelAttribute("professor") Professor professor) {
        TerminalProject project = new TerminalProject();

        ModelAndView model = new ModelAndView("add-project");
        model.addObject("professorForm", professor);
        model.addObject("projectForm", project);

        return model;
    }

    @RequestMapping(value = "/addProject")
    public ModelAndView showAddProject(@ModelAttribute("projectForm") TerminalProject project,
                                       @ModelAttribute("professorForm") Professor professor) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        services = (ProfessorManagerService) ctx.getBean("professorServices");

        services.addProject(professor, project);

        System.out.println("Datos del Proyecto:" +
                "\nTítulo: " + project.getTitle() +
                "\nEstudiantes: " + project.getStudentsQuantity() +
                "\nEstado: " + project.getState());

        return new ModelAndView("redirect:/showAddProject");
    }
}
