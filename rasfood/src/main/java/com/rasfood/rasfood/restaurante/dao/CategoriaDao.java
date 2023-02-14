package com.rasfood.rasfood.restaurante.dao;

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

   public void atualizarCategoria(Categoria categoria){
    this.entityManager.merge(categoria);
   }
    
   public void deletarCategoria(Categoria categoria){
    this.entityManager.remove(categoria);
   }
}
