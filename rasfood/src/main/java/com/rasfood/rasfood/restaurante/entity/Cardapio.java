package com.rasfood.rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String description;

    private Boolean disp;

    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;

    @OneToMany
    private List<OrdersCardapio> ordersCardapiosList = new ArrayList<>();

    @Column(name = "Data_de_registro")
    private LocalDate dataDeRegistro;

    public Cardapio(){}

    public Cardapio(String nome, String description, Boolean disp, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.description = description;
        this.disp = disp;
        this.valor = valor;
        this.categoria = categoria;
        this.dataDeRegistro = LocalDate.now();
    }

    public Cardapio(String nome, String description, Boolean disp, BigDecimal valor, LocalDate dataDeRegistro,Categoria categoria) {
        this.nome = nome;
        this.description = description;
        this.disp = disp;
        this.valor = valor;
        this.dataDeRegistro = dataDeRegistro;
        this.categoria = categoria;
    }

    public Cardapio(Integer id, String nome, String description, Boolean disp, BigDecimal valor,Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.disp = disp;
        this.valor = valor;
        this.categoria = categoria;
        dataDeRegistro = LocalDate.now();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisp() {
        return disp;
    }

    public void setDisp(Boolean disp) {
        this.disp = disp;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    @Override
    public String toString() {
        return "Prato [id=" + id + ", nome=" + nome + ", description=" + description + ", disp=" + disp + ", valor="
                + valor + ", dataDeRegistro=" + dataDeRegistro + ", "+categoria+"]";
    }

}