package com.practice.todolist.services;

import com.practice.todolist.models.dto.TareaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Tarea {

    public void crearTarifa(TareaDTO tareaDTO){
      log.info("Iniciando proceso de creacion de nueva tarifa.");

    }
}
