package com.example.wysiwyg_asignacion2.controllers;

import com.example.wysiwyg_asignacion2.AppConfig;
import com.example.wysiwyg_asignacion2.objects.Magazine;
import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.objects.ResearchArticle;
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

//        boolean addResult = services.addArticle(professor, article);

        return new ModelAndView("redirect:/showAddArticle");
    }
}
