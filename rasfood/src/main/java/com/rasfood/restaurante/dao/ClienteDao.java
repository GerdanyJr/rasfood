package com.rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.entity.Cliente;

public class ClienteDao {
    
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   public void cadastrarCliente(Cliente cliente){
    this.entityManager.persist(cliente);
   }

   public Cliente consultarCliente(Integer id){
    return this.entityManager.find(Cliente.class, id);
   }

   public List<Cliente> consultarClienteTodos(){
    String query = "SELECT c FROM Cliente c";
    return this.entityManager.createQuery(query,Cliente.class).getResultList();
   }

   public List<Cliente> consultarClientePorNome(String filtro){
    String query = "SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE UPPER(:nome)";
    return this.entityManager.createQuery(query,Cliente.class).setParameter("nome",filtro).getResultList();
   }

   public void atualizarCliente(Cliente cliente){
    this.entityManager.merge(cliente);
   }
    
   public void deletarCliente(Cliente cliente){
    this.entityManager.remove(cliente);
   }
}
