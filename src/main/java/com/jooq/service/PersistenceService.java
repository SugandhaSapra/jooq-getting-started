package com.jooq.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class PersistenceService {

    @Autowired
    private BeanFactory beans;

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactoryBean = beans.getBean("entityManagerFactory", EntityManagerFactory.class);
        return entityManagerFactoryBean.createEntityManager();
    }

}
