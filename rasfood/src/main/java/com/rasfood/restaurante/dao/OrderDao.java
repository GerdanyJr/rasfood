package com.rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Cliente;
import com.rasfood.restaurante.entity.Order;
import com.rasfood.restaurante.vo.ItensPrincipaisVo;

public class OrderDao {

    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarOrder(Order order) {
        this.entityManager.persist(order);
    }

    public Order consultarOrder(Integer id) {
        return this.entityManager.find(Order.class, id);
    }

    public List<Order> consultarOrderTodos() {
        String query = "SELECT o FROM Order cat";
        return this.entityManager.createQuery(query, Order.class).getResultList();
    }

    public Cliente joinFetchCliente(Integer id){
        String jpql = "SELECT o FROM Order o JOIN FETCH o.client WHERE o.id = :id";
        return this.entityManager.createQuery(jpql,Cliente.class).setParameter("id",id).getSingleResult();
    } 

    public List<Order> consultarOrderPorNome(String filtro) {
        String query = "SELECT o FROM Order o WHERE UPPER(o.nome) LIKE UPPER(:nome)";
        return this.entityManager.createQuery(query, Order.class).setParameter("nome", filtro).getResultList();
    }

    public List<ItensPrincipaisVo> consultarItemsMaisVendidos() {
        String query = "SELECT new com.rasfood.restaurante.vo.ItensPrincipaisVo( "+
            "c.nome,SUM(oc.quantidade)) FROM Order o " +
            "JOIN OrdersCardapio oc on o.id = oc.cardapio.id "+
            "JOIN oc.cardapio c "+
            "GROUP BY c.nome "+
            "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(query, ItensPrincipaisVo.class).getResultList();
    }

    public void atualizarOrder(Order order) {
        this.entityManager.merge(order);
    }

    public void deletarOrder(Order order) {
        this.entityManager.remove(order);
    }
}
