package com.service.impl;

import com.dao.IIngresoDao;
import com.domain.Ingreso;
import com.dto.IngresoDto;
import com.service.IIngresoService;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoServiceImpl implements IIngresoService {

    @Autowired
    private IIngresoDao IngresoDao;

    @Override
    public void Save(IngresoDto IngresoDto) {
        Ingreso IdeIngreso = new Ingreso();
        IdeIngreso.setIngreso(IngresoDto.getIngreso());
        IdeIngreso.setFechaIngreso(LocalDate.parse(IngresoDto.getFechaIngreso(), DateTimeFormat.forPattern("dd/MM/yyyy")).toDate());
        IdeIngreso.setCuenta(IngresoDto.getCuenta());
        IdeIngreso.setDescripcion(IngresoDto.getDescripcion());
        IngresoDao.Save(IdeIngreso);
    }

    @Override
    public void Update(IngresoDto IngresoDto) {
    Ingreso IdeIngreso = IngresoDao.GetById(IngresoDto.getIdIngreso());
        IdeIngreso.setIngreso(IngresoDto.getIngreso());
        IdeIngreso.setFechaIngreso(LocalDate.parse(IngresoDto.getFechaIngreso(), DateTimeFormat.forPattern("dd/MM/yyyy")).toDate());
        IdeIngreso.setCuenta(IngresoDto.getCuenta());
        IdeIngreso.setDescripcion(IngresoDto.getDescripcion());
        IngresoDao.Save(IdeIngreso);
    }

    @Override
    public void Delete(Ingreso Entity) {
        IngresoDao.Delete(Entity);
    }

    @Override
    public IngresoDto GetById(Integer Id) {
        Ingreso IdeIngreso = IngresoDao.GetById(Id);
        if (IdeIngreso == null) {
            return null;
        }else {
            IngresoDto IngresoDto = new IngresoDto();
            IngresoDto.setIdIngreso(IdeIngreso.getIdIngreso());
            IngresoDto.setIngreso(IdeIngreso.getIngreso());
            IngresoDto.setFechaIngreso(LocalDate.fromDateFields(IdeIngreso.getFechaIngreso()).toString("dd/MM/yyyy"));
            IngresoDto.setDescripcion(IdeIngreso.getDescripcion());
            IngresoDto.setCuenta(IdeIngreso.getCuenta());
            return IngresoDto;
        }

    }

    @Override
    public IngresoDto GetAll() {
        List<Ingreso> IngresoList = IngresoDao.GetAll();
        List<IngresoDto> IngresoDtoList = new ArrayList<>();
        for (Ingreso AluLop: IngresoList)
        {
            IngresoDto IngresoDTO = new IngresoDto();
            IngresoDTO.setIdIngreso(AluLop.getIdIngreso());
            IngresoDTO.setIngreso(AluLop.getIngreso());
            IngresoDTO.setFechaIngreso(LocalDate.fromDateFields(AluLop.getFechaIngreso()).toString("dd/MM/yyyy"));
            IngresoDTO.setDescripcion(AluLop.getDescripcion());
            IngresoDTO.setCuenta(AluLop.getCuenta());
            IngresoDtoList.add(IngresoDTO);
        }
        return (IngresoDto) IngresoDtoList;
    }
}
