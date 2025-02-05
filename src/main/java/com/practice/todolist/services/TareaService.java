package com.practice.todolist.services;

import com.practice.todolist.mapper.TareaInDtoToTarea;
import com.practice.todolist.mapper.TareaToTareaDto;
import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import com.practice.todolist.repository.TareaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private TareaInDtoToTarea mapperDtoToTarea;

    @Autowired
    private TareaToTareaDto mapperTareaToDto;

    @Transactional
    public void crearTarea(TareaDTO tareaDTO) {
        log.info("Iniciando proceso de mapeo para la creacion de una nueva tarea.");
        Tarea tarea = mapperDtoToTarea.map(tareaDTO);
        tareaRepository.save(tarea);
        log.info("Éxtio en la creación de la nueva tarea.");
    }


    public List<TareaDTO> listarTareas(){
        return mapeoListaTareas(tareaRepository.findAll());
    }

    private List<TareaDTO> mapeoListaTareas(List<Tarea>tareas){
        log.info("Iniciando proceso de mapeo para listar todas las tareas.");
        List<TareaDTO> tareasDto = tareas.stream().map(mapperTareaToDto::map).toList();
        log.info("Éxtio en el proceso de listar todas las tareas.");
        return tareasDto;
    }

}
