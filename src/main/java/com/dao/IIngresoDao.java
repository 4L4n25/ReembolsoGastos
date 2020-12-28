package com.dao;

import com.domain.Ingreso;

import java.util.List;

public interface IIngresoDao {
    void Save(Ingreso Entity);
    void Update(Ingreso Entity);
    void Delete(Ingreso Entity);
    Ingreso GetById(int Id);
    List<Ingreso> GetAll();
}
