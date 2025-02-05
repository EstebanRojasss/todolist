package com.practice.todolist.mapper;

import com.practice.todolist.models.dto.TarifaDTO;
import com.practice.todolist.models.entities.Tarifa;

public class TarifaInDtoToTarifa implements IMapper<TarifaDTO, Tarifa>{

    @Override
    public Tarifa map(TarifaDTO in) {
        Tarifa tarifa = new Tarifa();
        tarifa.setNombre(in.nombre());
        tarifa.setPrioridad(in.prioridad());
        tarifa.setRealizado(in.realizado());
        tarifa.setDescripcion(in.descripcion());
        return tarifa;
    }
}
