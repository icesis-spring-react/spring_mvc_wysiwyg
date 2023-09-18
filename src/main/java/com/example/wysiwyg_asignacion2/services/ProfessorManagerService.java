package com.example.wysiwyg_asignacion2.services;

import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfessorManagerService {

    @Autowired
    ProfessorRepository professorRepo;

    public void addProfessor(Professor professor) {
        professorRepo.add(professor);
    }

    public boolean loginProfessor(Professor professor) {
        return professorRepo.professorLogin(professor);
    }
}
