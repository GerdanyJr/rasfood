package com.rasfood.restaurante.services.test;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.CategoriaDao;
import com.rasfood.restaurante.util.CargaDeDados;
import com.rasfood.restaurante.util.JPAUtil;

public class CardapioService {
    public static void main(String[] args) {
        final EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

    }
}
