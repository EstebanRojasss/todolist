package com.practice.todolist.controllers;

import com.practice.todolist.models.dto.TareaDTO;
import com.practice.todolist.models.entities.Tarea;
import com.practice.todolist.services.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    @Operation(description = "Endpoint responsable de agregar una nueva tarea.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Éxito en la creacion de la nueva tarea."),
            @ApiResponse(responseCode = "422", description = "Error de procesamiento de datos"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")
    })
    public ResponseEntity<TareaDTO> crearTarea(@RequestBody TareaDTO tareaDTO) {
        tareaService.crearTarea(tareaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaDTO);
    }

    @GetMapping
    @Operation(description = "Endpoint encargado de listar las tareas.")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Éxito en la operación de listado de tareas.")
    )
    public ResponseEntity<List<TareaDTO>> listarTareas() {
        return ResponseEntity.ok(tareaService.listarTareas());
    }

    @PutMapping
    @Operation(description = "Endpoint encargado de actualizar una tarea.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Éxito en la operación de actualización de la tarea."),
            @ApiResponse(responseCode = "404", description = "No se encontró la tarea."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    }
    )
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tarea));
    }

    @DeleteMapping
    @Operation(description = "Endpoint encargado de eliminar una tarea.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Éxito al eliminar la tarea."),
            @ApiResponse(responseCode = "404", description = "No se enontró la tarea."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public ResponseEntity<Optional<Tarea>> eliminarTarea(@RequestParam Long id){
        return ResponseEntity.ok(tareaService.eliminarTarea(id));
    }
}
