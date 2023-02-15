package com.rasfood.rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Valor_total")
    private BigDecimal valorTotal;

    @Column(name = "Data_de_criação")
    private LocalDate dataDePedido = LocalDate.now();
    
    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<OrdersCardapio> ordersCardapiosList;

    public Order(){}

    public Order(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataDePedido() {
        return dataDePedido;
    }

    public void setDataDePedido(LocalDate dataDePedido) {
        this.dataDePedido = dataDePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", valorTotal=" + valorTotal + ", dataDePedido=" + dataDePedido + ", "
                + cliente + "]";
    }
}
