package com.example.wysiwyg_asignacion2;

import com.example.wysiwyg_asignacion2.objects.Professor;
import com.example.wysiwyg_asignacion2.repositories.ProfessorRepository;
import com.example.wysiwyg_asignacion2.services.ProfessorManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProfessorManagerService professorServices() {
        return new ProfessorManagerService();
    }

    @Bean
    public ProfessorRepository professorRepo() {
        return new ProfessorRepository();
    }

    @Bean
    public Professor professor() {
        return new Professor();
    }
}
