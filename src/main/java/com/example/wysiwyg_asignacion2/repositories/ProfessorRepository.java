package com.example.wysiwyg_asignacion2.repositories;

import com.example.wysiwyg_asignacion2.objects.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    private static List<Professor> professors = new ArrayList<>();
    static {
        professors.add(new Professor("Alberto Gutierrez", "Doctor en Física de Partículas",
                "Albert", "Profe1"));
        professors.add(new Professor("Freddy Moreno", "Doctor en Biología del Desarrollo",
                "Fred", "Profe2"));
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
}
