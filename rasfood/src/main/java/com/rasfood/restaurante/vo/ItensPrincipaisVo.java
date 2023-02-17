package com.rasfood.restaurante.vo;

public class ItensPrincipaisVo {
    
    private String name;
    private long quantidade;
    
    public ItensPrincipaisVo(String name, long quantidade) {
        this.name = name;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }
}
