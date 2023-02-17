package com.rasfood.restaurante.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
    
    @Id
    private String cpf;

    private String nome;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Endereço>endereçosList = new ArrayList<>();
  
    public Cliente() {}

    public Cliente(String cpf, String nome, Endereço endereço) {
        this.cpf = cpf;
        this.nome = nome;
        endereçosList.add(endereço);
    }

    public void addEndereço(Endereço endereço){
        endereçosList.add(endereço);
        endereço.setCliente(this);
    }

    public List<Endereço> getEndereçosList() {
        return endereçosList;
    }

    public void setEndereçosList(List<Endereço> endereçosList) {
        this.endereçosList = endereçosList;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", endereçosList=" + endereçosList + "]";
    }

    
}
