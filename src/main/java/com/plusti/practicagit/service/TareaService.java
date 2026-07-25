package com.plusti.practicagit.service;

import com.plusti.practicagit.model.Tarea;
import com.plusti.practicagit.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public Tarea buscarPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new TareaNoEncontradaException(id));
    }

    public Tarea crear(Tarea tarea) {
        tarea.setId(null);
        return tareaRepository.save(tarea);
    }

    public Tarea actualizar(Long id, Tarea datosActualizados) {
        Tarea tarea = buscarPorId(id);
        tarea.setTitulo(datosActualizados.getTitulo());
        tarea.setDescripcion(datosActualizados.getDescripcion());
        tarea.setCompletada(datosActualizados.isCompletada());
        return tareaRepository.save(tarea);
    }

    public Tarea marcarComoCompletada(Long id) {
        Tarea tarea = buscarPorId(id);
        tarea.setCompletada(true);
        return tareaRepository.save(tarea);
    }

    public void eliminar(Long id) {
        Tarea tarea = buscarPorId(id);
        tareaRepository.delete(tarea);
    }
}
