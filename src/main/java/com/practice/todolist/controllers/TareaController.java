package com.practice.todolist.controllers;

import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import com.practice.todolist.services.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    @Operation(description = "Endpoint responsable de agregar una nueva tarea.")
    public ResponseEntity<TareaDTO> crearTarea(@RequestBody TareaDTO tareaDTO){
        tareaService.crearTarea(tareaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaDTO);
    }

    @GetMapping
    @Operation(description = "Endpoint encargado de listar las tareas.")
    public ResponseEntity<List<TareaDTO>> listarTareas(){
        return ResponseEntity.ok(tareaService.listarTareas());
    }
}
