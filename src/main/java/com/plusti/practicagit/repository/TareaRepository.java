package com.plusti.practicagit.repository;

import com.plusti.practicagit.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
