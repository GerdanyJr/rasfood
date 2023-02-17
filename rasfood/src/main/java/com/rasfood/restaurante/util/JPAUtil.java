package com.rasfood.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory RASFOOD_ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("rasFood");

    public static EntityManager getEntityManagerRasFood() {
        return RASFOOD_ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void closeRasFoodFactory() {
        RASFOOD_ENTITY_MANAGER_FACTORY.close();
    }

}
