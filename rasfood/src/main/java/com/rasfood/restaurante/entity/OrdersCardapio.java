package com.rasfood.restaurante.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders_cardapio")
public class OrdersCardapio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Cardapio cardapio;

    private BigDecimal valor;

    private Integer quantidade;

    public OrdersCardapio() {
    }

    public OrdersCardapio(Integer id, Order order, Cardapio cardapio, Integer quantidade) {
        this.id = id;
        this.order = order;
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valor = cardapio.getValor();
    }

    public OrdersCardapio(Cardapio cardapio, Integer quantidade) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valor = cardapio.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdersCardapio [id=" + id  + ", cardapio=" + cardapio + ", valor=" + valor
                + ", quantidade=" + quantidade + "]";
    }
}
