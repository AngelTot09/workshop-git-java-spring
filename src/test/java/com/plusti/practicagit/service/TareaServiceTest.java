package com.plusti.practicagit.service;

import com.plusti.practicagit.model.Tarea;
import com.plusti.practicagit.repository.TareaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TareaServiceTest {

    @Mock
    private TareaRepository tareaRepository;

    private TareaService tareaService;

    @BeforeEach
    void setUp() {
        tareaService = new TareaService(tareaRepository);
    }

    @Test
    void buscarPorId_debeLanzarExcepcion_siNoExiste() {
        when(tareaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(TareaNoEncontradaException.class, () -> tareaService.buscarPorId(99L));
    }

    @Test
    void marcarComoCompletada_debeActualizarElEstado() {
        Tarea tarea = new Tarea("Estudiar para el examen", "Repasar el capítulo 4", false);
        tarea.setId(1L);

        when(tareaRepository.findById(1L)).thenReturn(Optional.of(tarea));
        when(tareaRepository.save(any(Tarea.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Tarea resultado = tareaService.marcarComoCompletada(1L);

        assertTrue(resultado.isCompletada());
        verify(tareaRepository).save(tarea);
    }

    @Test
    void crear_debeIgnorarIdEnviadoPorElCliente() {
        Tarea nuevaTarea = new Tarea("Nueva tarea", "Descripción", false);
        nuevaTarea.setId(500L);

        when(tareaRepository.save(any(Tarea.class))).thenAnswer(invocation -> invocation.getArgument(0));

        tareaService.crear(nuevaTarea);

        assertNull(nuevaTarea.getId());
    }
}
