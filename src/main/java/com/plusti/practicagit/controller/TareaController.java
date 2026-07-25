package com.plusti.practicagit.controller;

import com.plusti.practicagit.model.Tarea;
import com.plusti.practicagit.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@Valid @RequestBody Tarea tarea) {
        return tareaService.crear(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @Valid @RequestBody Tarea tarea) {
        return tareaService.actualizar(id, tarea);
    }

    @PatchMapping("/{id}/completar")
    public Tarea marcarComoCompletada(@PathVariable Long id) {
        return tareaService.marcarComoCompletada(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
    }
}
