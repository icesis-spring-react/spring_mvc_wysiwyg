package com.example.wysiwyg_asignacion2.repositories;

import com.example.wysiwyg_asignacion2.objects.Magazine;
import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.objects.ResearchArticle;
import com.example.wysiwyg_asignacion2.objects.TerminalProject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    private static List<Magazine> magazines = new ArrayList<>();
    static {
        Magazine mag1 = new Magazine("NEW YORK MAGAZINE", "10. 0773456058", "IDX");
        Magazine mag2 = new Magazine("ICESI MAGAZINE", "14. 05163416018", "IDX");
        Magazine mag3 = new Magazine("JAVERIANA MAGAZINE", "1. 23456789990", "NIDX");
        Magazine mag4 = new Magazine("TRASH MAGAZINE", "1. 4339887589", "NIDX");
        Magazine mag5 = new Magazine("MORE SCIENCE MAGAZINE", "19. 4339887510", "IDX");

        magazines.add(mag1);
        magazines.add(mag2);
        magazines.add(mag3);
        magazines.add(mag4);
        magazines.add(mag5);
    }

    private static List<Professor> professors = new ArrayList<>();
    static {
        Professor p1 = new Professor("Alberto Gutierrez", "Doctor en Física de Partículas",
                "Albert", "Profe1");
        p1.addArticle(new ResearchArticle("Artículo 1", "ACP", magazines.get(1)));
        p1.addArticle(new ResearchArticle("Artículo 2", "REV", magazines.get(3)));
        p1.addArticle(new ResearchArticle("Artículo 3", "ACP", magazines.get(1)));
        p1.addArticle(new ResearchArticle("Artículo 4", "DES", magazines.get(4)));
        p1.addArticle(new ResearchArticle("Artículo 5", "REV", magazines.get(1)));

        p1.addProject(new TerminalProject("Proyecto 1", 20, "Desarrollo"));
        p1.addProject(new TerminalProject("Proyecto 2", 20, "Desarrollo"));
        p1.addProject(new TerminalProject("Proyecto 3", 20, "Finalizado"));
        p1.addProject(new TerminalProject("Proyecto 4", 28, "Desarrollo"));
        p1.addProject(new TerminalProject("Proyecto 5", 20, "Finalizado"));

        Professor p2 = new Professor("Freddy Moreno", "Doctor en Biología del Desarrollo",
                "Fred", "Profe2");
        p2.addArticle(new ResearchArticle("Artículo 1", "REV", magazines.get(2)));
        p2.addArticle(new ResearchArticle("Artículo 2", "DES", magazines.get(2)));
        p2.addArticle(new ResearchArticle("Artículo 3", "ACP", magazines.get(3)));
        p2.addArticle(new ResearchArticle("Artículo 4", "DES", magazines.get(4)));
        p2.addArticle(new ResearchArticle("Artículo 5", "ACP", magazines.get(0)));

        p2.addProject(new TerminalProject("Proyecto 1", 16, "Finalizado"));
        p2.addProject(new TerminalProject("Proyecto 2", 20, "Finalizado"));
        p2.addProject(new TerminalProject("Proyecto 3", 21, "Finalizado"));
        p2.addProject(new TerminalProject("Proyecto 4", 10, "Desarrollo"));
        p2.addProject(new TerminalProject("Proyecto 5", 32, "Finalizado"));

        professors.add(p1);
        professors.add(p2);
    }

    public void add(Professor professor) {
        if (validateProfessorExistence(professor) == null) {
            professors.add(professor);
        }
    }

    private Professor validateProfessorExistence(Professor p) {
        String profUsername = p.getUsername();

        for (Professor professor : professors) {
            if (professor.getUsername().equals(profUsername)) {
                return professor;
            }
        }

        return null;
    }

    public boolean professorLogin(Professor p) {
        Professor found = validateProfessorExistence(p);

        if (found != null) {
            return found.getPassword().equals(p.getPassword());
        }

        return false;
    }

    public Professor getProfessor(Professor professor) {
        return validateProfessorExistence(professor);
    }
}
