package com.practice.todolist.mapper;

import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import org.springframework.stereotype.Component;

@Component
public class TareaToTareaDto implements IMapper<Tarea, TareaDTO> {

    @Override
    public TareaDTO map(Tarea in) {
        return new TareaDTO(in.getNombre(),
                in.getPrioridad(),
                in.getRealizado(),
                in.getDescripcion());
    }
}
