package com.rasfood.rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.entity.Order;

public class OrderDao {
    
    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   public void cadastrarOrder(Order order){
    this.entityManager.persist(order);
   }

   public Order consultarOrder(Integer id){
    return this.entityManager.find(Order.class, id);
   }

   public List<Order> consultarOrderTodos(){
    String query = "SELECT o FROM Order cat";
    return this.entityManager.createQuery(query,Order.class).getResultList();
   }

   public List<Order> consultarOrderPorNome(String filtro){
    String query = "SELECT o FROM Order o WHERE UPPER(o.nome) LIKE UPPER(:nome)";
    return this.entityManager.createQuery(query,Order.class).setParameter("nome",filtro).getResultList();
   }

   public void atualizarOrder(Order order){
    this.entityManager.merge(order);
   }
    
   public void deletarOrder(Order order){
    this.entityManager.remove(order);
   }
}
