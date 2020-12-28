package com.dao.impl;

import com.dao.IIngresoDao;
import com.domain.Ingreso;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

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
        IEntityManager.merge(Entity);
    }

    @Override
    public void Delete(Ingreso Entity) {
        IEntityManager.remove((IEntityManager.contains(Entity)? Entity:IEntityManager.merge(Entity)));
    }

    @Override
    public Ingreso GetById(int Id) {
        return IEntityManager.find(Ingreso.class, Id);
    }

    @Override
    public List GetAll() {
        return IEntityManager.createQuery("FROM Ingreso").getResultList();
    }
    
}
