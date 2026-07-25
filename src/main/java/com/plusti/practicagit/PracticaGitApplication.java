package com.plusti.practicagit;

import com.plusti.practicagit.model.Tarea;
import com.plusti.practicagit.repository.TareaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Punto de entrada de la aplicación.
 *
 * Este proyecto es un repositorio de PRÁCTICA para el curso de Programación II.
 * Su objetivo es servir como base para ejercicios de control de versiones con
 * Git y GitHub (fork, commits, ramas, Pull Requests, merge, squash and merge,
 * rebase and merge y git log). Ver README.md para las instrucciones completas.
 */
@SpringBootApplication
public class PracticaGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaGitApplication.class, args);
    }

    /**
     * Carga datos de ejemplo al iniciar la aplicación, únicamente si la base
     * de datos está vacía. Útil para probar los endpoints inmediatamente.
     */
    @Bean
    CommandLineRunner cargarDatosDeEjemplo(TareaRepository tareaRepository) {
        return args -> {
            if (tareaRepository.count() == 0) {
                tareaRepository.save(new Tarea("Configurar el entorno de desarrollo", "Instalar JDK 17, Maven y un IDE", false));
                tareaRepository.save(new Tarea("Leer el README del proyecto", "Repasar las instrucciones antes de empezar", false));
                tareaRepository.save(new Tarea("Hacer fork del repositorio", "Bifurcar el repositorio hacia la cuenta personal de GitHub", true));
            }
        };
    }
}
