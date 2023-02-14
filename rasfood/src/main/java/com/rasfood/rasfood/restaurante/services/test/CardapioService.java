package com.rasfood.rasfood.restaurante.services.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.dao.PratoDao;
import com.rasfood.rasfood.restaurante.entity.Prato;
import com.rasfood.rasfood.restaurante.util.JPAUtil;

public class PratoService {
    public static void main(String[] args) {
        
        Prato risotto = new Prato(null,"Risotto de frutos do mar","Risotto com lula, polvo e mariscos",true,BigDecimal.valueOf(88.50));
        Prato salmao = new Prato(null,"Salmão ao molho de maracujá","Salmão grelhado ao moho de maracujá",true,BigDecimal.valueOf(50.00));

        EntityManager em = JPAUtil.getEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(em);
        em.getTransaction().begin();
        pratoDao.cadastrar(risotto);
        em.flush();
        pratoDao.cadastrar(salmao);
        em.flush();
        System.out.println("O prato consultado foi:"+pratoDao.consultar(2));

        pratoDao.excluir(risotto);
        System.out.println("=================================================");
        System.out.println("O prato consultado foi:"+pratoDao.consultar(2));
        System.out.println("=================================================");
        em.clear();
        risotto.setValor(BigDecimal.valueOf(75.50));
        pratoDao.atualizar(salmao);
    }
}
