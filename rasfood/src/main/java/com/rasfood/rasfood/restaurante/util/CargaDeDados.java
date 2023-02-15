package com.rasfood.rasfood.restaurante.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.rasfood.rasfood.restaurante.dao.CardapioDao;
import com.rasfood.rasfood.restaurante.dao.CategoriaDao;
import com.rasfood.rasfood.restaurante.entity.Cardapio;
import com.rasfood.rasfood.restaurante.entity.Categoria;

public class CargaDeDados {
    public static void cadatrarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria saida = new Categoria("Saidas");
        Categoria principal = new Categoria("Pratos principais");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrarCategoria(saida);
        entityManager.flush();
        categoriaDao.cadastrarCategoria(entrada);
        entityManager.flush();
        categoriaDao.cadastrarCategoria(salada);
        entityManager.flush();
        categoriaDao.cadastrarCategoria(principal);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarCategoriaTodos();
        List<Cardapio> cardapios = new ArrayList<>();
        Cardapio risotto = new Cardapio("Risotto de frutos do mar","Risotto com lula, polvo e mariscos",true,BigDecimal.valueOf(88.50),categorias.get(0));
        cardapios.add(risotto);
        Cardapio salmao = new Cardapio("Salmão ao molho de maracujá","Salmão grelhado ao moho de maracujá",true,BigDecimal.valueOf(50.00),categorias.get(1));
        cardapios.add(salmao);
        Cardapio bife = new Cardapio("Bife acebolado","Bife frito acompanhado com cebola",true,BigDecimal.valueOf(30.0),categorias.get(2));
        cardapios.add(bife);
        Cardapio arroz = new Cardapio("Arroz","Arroz com tempero de alho",true,BigDecimal.valueOf(15.0),categorias.get(0));
        cardapios.add(arroz);
        Cardapio feijao = new Cardapio("Feijão preto","Feijao preto com carne",true,BigDecimal.valueOf(40.0),categorias.get(2));
        cardapios.add(feijao);
        Cardapio calabresa = new Cardapio("Calabresa","Calabresa com cebola",true,BigDecimal.valueOf(10.0),categorias.get(0));
        cardapios.add(calabresa);
        Cardapio batata = new Cardapio("Batata","Batata frita com molho de chedar",true,BigDecimal.valueOf(40.0),categorias.get(0));
        cardapios.add(batata);
        Cardapio pirao = new Cardapio("Pirão","Pirão",true,BigDecimal.valueOf(70.0),categorias.get(2));
        cardapios.add(pirao);
        Cardapio cenoura = new Cardapio("Salada de cenoura","Salada de cenoura com batata",true,BigDecimal.valueOf(30.0),categorias.get(0));
        cardapios.add(cenoura);


        for(Cardapio cardapio:cardapios){
            cardapioDao.cadastrarCardapio(cardapio);
            entityManager.flush();
        }
        entityManager.clear();
    }
}
