package com.rasfood.rasfood.restaurante.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Categorias")
public class Categoria {
    
    @Id
    private Integer id;
    private String nome;

    public Categoria(){}

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nome=" + nome + "]";
    };
}
