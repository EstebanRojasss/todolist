package com.practice.todolist.services;

import com.practice.todolist.exceptions.Exception;
import com.practice.todolist.mapper.TareaInDtoToTarea;
import com.practice.todolist.mapper.TareaToTareaDto;
import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import com.practice.todolist.repository.TareaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        log.info("Éxito en la creación de la nueva tarea.");
    }


    public List<TareaDTO> listarTareas() {
        return mapeoListaTareas(tareaRepository.findAll());
    }

    private List<TareaDTO> mapeoListaTareas(List<Tarea> tareas) {
        log.info("Iniciando proceso de mapeo para listar todas las tareas.");
        List<TareaDTO> tareasDto = tareas.stream().map(mapperTareaToDto::map).toList();
        log.info("Éxito en el proceso de listar todas las tareas.");
        return tareasDto;
    }

    public Tarea actualizarTarea(Tarea tareaNueva) {
        log.info("Iniciando proceso de busqueda de la tarea.");
        return tareaRepository.findById(tareaNueva.getId()).stream().
                map(tareaActual -> {
                    tareaActual.setNombre(tareaNueva.getNombre());
                    tareaActual.setRealizado(tareaNueva.getRealizado());
                    tareaActual.setPrioridad(tareaNueva.getPrioridad());
                    tareaActual.setDescripcion(tareaNueva.getDescripcion());
                    log.info("Éxito en la actualización de la tarea.");
                    return tareaRepository.save(tareaActual);
                }).findFirst().orElseThrow(() -> new Exception("No se encontró la tarea", HttpStatus.NOT_FOUND));
    }

    public Optional<Tarea> eliminarTarea(Long id) {
        log.info("Iniciando proceso de búsqueda de tarea para la eliminación");
            Optional<Tarea>tareaAEliminar =  tareaRepository.findById(id);
            if(tareaAEliminar.isEmpty()){
                throw new Exception("No se encontró la tarea", HttpStatus.NOT_FOUND);
            }
            tareaRepository.deleteById(id);
            log.info("Éxito en la eliminación de la tarea.");
            return tareaAEliminar;
    }

}
