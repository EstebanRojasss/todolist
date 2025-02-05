package com.practice.todolist.mapper;

import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import org.springframework.stereotype.Component;

@Component
public class TareaInDtoToTarea implements IMapper<TareaDTO, Tarea>{

    @Override
    public Tarea map(TareaDTO in) {
        Tarea tarea = new Tarea();
        tarea.setNombre(in.nombre());
        tarea.setPrioridad(in.prioridad());
        tarea.setRealizado(false);
        tarea.setDescripcion(in.descripcion());
        return tarea;
    }
}
