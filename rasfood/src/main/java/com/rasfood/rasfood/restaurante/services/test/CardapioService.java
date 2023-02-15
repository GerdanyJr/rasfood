package com.rasfood.rasfood.restaurante.services.test;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.rasfood.restaurante.dao.CategoriaDao;
import com.rasfood.rasfood.restaurante.util.CargaDeDados;
import com.rasfood.rasfood.restaurante.util.JPAUtil;

public class CardapioService {
    public static void main(String[] args) {
        final EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        CargaDeDados.cadatrarCategorias(entityManager);
        CargaDeDados.cadastrarProdutosCardapio(entityManager);

        entityManager.close();
    }
}
