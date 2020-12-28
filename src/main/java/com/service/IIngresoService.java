package com.service;

import com.domain.Ingreso;
import com.dto.IngresoDto;

public interface IIngresoService {
    void Save(IngresoDto IngresoDto);

    void Update(IngresoDto IngresoDto);

    void Delete(Ingreso Entity);

    IngresoDto GetById(Integer Id);

    IngresoDto GetAll();
}
