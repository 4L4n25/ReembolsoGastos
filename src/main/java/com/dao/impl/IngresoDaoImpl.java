package com.dao.impl;

import com.dao.IIngresoDao;
import com.domain.Ingreso;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class IngresoDaoImpl implements IIngresoDao {
@PersistenceContext
private EntityManager IEntityManager;
    @Override
    public void Save(Ingreso Entity) {
        IEntityManager.persist(Entity);
    }

    @Override
    public void Update(Ingreso Entity) {

    }

    @Override
    public void Delete(Ingreso Entity) {

    }

    @Override
    public Ingreso GetById(int Id) {
        return null;
    }

    @Override
    public List<Ingreso> GetAll() {
        return null;
    }

    @Override
    public List<Ingreso> FindAll() {
        return null;
    }
}
