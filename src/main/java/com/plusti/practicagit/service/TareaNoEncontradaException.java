package com.plusti.practicagit.service;

public class TareaNoEncontradaException extends RuntimeException {

    public TareaNoEncontradaException(Long id) {
        super("No se encontró la tarea con id " + id);
    }
}
