package com.rasfood.rasfood.restaurante.dao;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.entity.Cardapio;

public class CardapioDao {
    
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrarCardapio(final Cardapio prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: "+prato);
    }

    public Cardapio consultarCardapio(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizarCardapio(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluirCardapio(final Cardapio prato){
        this.entityManager.remove(prato);
    }
}
