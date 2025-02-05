package com.practice.todolist.services;

import com.practice.todolist.mapper.TareaInDtoToTarea;
import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import com.practice.todolist.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TareaInDtoToTarea mapperTareaDtotoTarea;

    public void crearTarea(TareaDTO tareaDTO) {
        log.info("Iniciando proceso de mapeo para la creacion de una nueva tarea.");
        Tarea tarea = mapperTareaDtotoTarea.map(tareaDTO);
        tareaRepository.save(tarea);
        log.info("Éxtio en la creación de la nueva tarea.");
    }

}
