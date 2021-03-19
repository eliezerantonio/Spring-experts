package com.stackcode.gestao.model;

import org.hibernate.validator.constraints.NotBlank;

public class Produto {

    @NotBlank
    private String sku;
    
    @NotBlank
    private String nome;
    
    @NotBlank
    private String descricao;

    public Produto() {

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
