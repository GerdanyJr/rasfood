package com.rasfood.rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.entity.Categoria;

public class CategoriaDao {
    
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   public void cadastrarCategoria(Categoria categoria){
    this.entityManager.persist(categoria);
   }

   public Categoria consultarCategoria(Integer id){
    return this.entityManager.find(Categoria.class, id);
   }

   public List<Categoria> consultarCategoriaTodos(){
    String query = "SELECT cat FROM Categoria cat";
    return this.entityManager.createQuery(query,Categoria.class).getResultList();
   }

   public List<Categoria> consultarCategoriaPorNome(String filtro){
    String query = "SELECT cat FROM Categoria cat WHERE UPPER(cat.nome) LIKE UPPER(:nome)";
    return this.entityManager.createQuery(query,Categoria.class).setParameter("nome",filtro).getResultList();
   }

   public void atualizarCategoria(Categoria categoria){
    this.entityManager.merge(categoria);
   }
    
   public void deletarCategoria(Categoria categoria){
    this.entityManager.remove(categoria);
   }
}
