package com.example.wysiwyg_asignacion2.controllers;

import com.example.wysiwyg_asignacion2.AppConfig;
import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.services.ProfessorManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
