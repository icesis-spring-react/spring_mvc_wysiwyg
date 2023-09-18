package com.example.wysiwyg_asignacion2.services;

import com.example.wysiwyg_asignacion2.objects.Magazine;
import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.objects.ResearchArticle;
import com.example.wysiwyg_asignacion2.objects.TerminalProject;
import com.example.wysiwyg_asignacion2.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfessorManagerService {

    @Autowired
    ProfessorRepository professorRepo;

    public void addProfessor(Professor professor) {
        professorRepo.add(professor);
    }

    public boolean loginProfessor(Professor professor) {
        return professorRepo.professorLogin(professor);
    }

    public Professor getProfessor(Professor professor) {
        return professorRepo.getProfessor(professor);
    }

    public boolean addArticle(Professor professor, ResearchArticle article) {
        return professorRepo.addArticle(professor, article);
    }

    public boolean addArticle(Professor professor, TerminalProject project) {
        return professorRepo.addProject(professor, project);
    }

    public ArrayList<Magazine> getMagazines() {
        return professorRepo.getMagazines();
    }

}
