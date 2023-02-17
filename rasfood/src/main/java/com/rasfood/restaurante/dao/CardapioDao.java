package com.rasfood.restaurante.dao;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Cardapio;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarCardapio(final Cardapio prato) {
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: " + prato);
    }

    public Cardapio consultarCardapioPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarCardapioPorCategoria(String categoria){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.categoria.nome) = UPPER(:categoria)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("categoria",categoria).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarCardapioTodos() {
        try {
            String query = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(query, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultaraCardapioPorValor(final BigDecimal filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :preço";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("preço", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizarCardapio(final Cardapio prato) {
        this.entityManager.merge(prato);
    }

    public void excluirCardapio(final Cardapio prato) {
        this.entityManager.remove(prato);
    }
}
