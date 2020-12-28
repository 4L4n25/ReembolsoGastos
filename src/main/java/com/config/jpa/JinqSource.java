package com.config.jpa;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class JinqSource
{
    private JinqJPAStreamProvider Streams;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory EntityManager) throws Exception
    {
        Streams = new JinqJPAStreamProvider(EntityManager);
    }

    public <U> JPAJinqStream<U> StreamAll(EntityManager Manager, Class<U> entity)
    {
        return Streams.streamAll(Manager, entity);
    }
}