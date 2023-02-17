package com.rasfood.restaurante.dao;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Endereço;
import com.rasfood.restaurante.util.JPAUtil;

public class EndereçoDao {
    EntityManager entityManager = JPAUtil.getEntityManagerRasFood();

    public EndereçoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrarEndereço(Endereço endereço){
        this.entityManager.persist(endereço);
    }

    public Endereço consultarEndereço(Integer id){
        String jpql = "SELECT e FROM Endereço e WHERE e.id = :id";
        return this.entityManager.createQuery(jpql,Endereço.class).setParameter("id",id).getSingleResult();
    }

    public void atualizarEndereço(Endereço endereço){
        this.entityManager.merge(endereço);
    }

    public void deletarEndereço(Endereço endereço){
        this.entityManager.remove(endereço);
    }

}
