package com.rasfood.restaurante.services.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.restaurante.dao.ClienteDao;
import com.rasfood.restaurante.dao.OrderDao;
import com.rasfood.restaurante.entity.Cliente;
import com.rasfood.restaurante.entity.Endereço;
import com.rasfood.restaurante.entity.Order;
import com.rasfood.restaurante.entity.OrdersCardapio;
import com.rasfood.restaurante.util.CargaDeDados;
import com.rasfood.restaurante.util.JPAUtil;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrderDao ordemDao = new OrderDao(entityManager);
        entityManager.getTransaction().begin();
        CargaDeDados.cadatrarCategorias(entityManager);
        CargaDeDados.cadastrarProdutosCardapio(entityManager);

        Endereço endereço = new Endereço("40000000", "Fernando Spinola", "Ao lado do atelie", "Bahia", "Vitoria da Conquista", null);
        Cliente cliente = new Cliente("123456789", "Joao Silva", endereço);
        Cliente roberto = new Cliente("123456789", "Roberto Silva", endereço);
        cliente.addEndereço(endereço);
        Order order = new Order(cliente);
        order.addOrdersCardapio(new OrdersCardapio(cardapioDao.consultarCardapioPorId(1), 3));        
        clienteDao.cadastrarCliente(cliente);
        ordemDao.cadastrarOrder(order);
        entityManager.flush();
        entityManager.getTransaction().commit();
        List<Cliente> list = clienteDao.consultarClientePorNome("J");
        System.out.println("========================");
        list.forEach(c->System.out.println(c));
        System.out.println("========================");
        entityManager.close();
        JPAUtil.closeRasFoodFactory();
    }
}
