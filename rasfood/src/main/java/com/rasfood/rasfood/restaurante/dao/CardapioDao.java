package com.rasfood.rasfood.restaurante.dao;

import java.util.List;

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

    public Cardapio consultarCardapioPorId(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarCardapioTodos(){
        String query = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(query,Cardapio.class).getResultList();
    }

    public void atualizarCardapio(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluirCardapio(final Cardapio prato){
        this.entityManager.remove(prato);
    }
}
