package com.practice.todolist.models.dto;


public record TareaDTO(
                        String nombre,
                        Integer prioridad,
                        Boolean realizado,
                        String descripcion) {
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Integer prioridad() {
        return prioridad;
    }

    @Override
    public Boolean realizado() {
        return realizado;
    }

    @Override
    public String descripcion() {
        return descripcion;
    }
}
