package com.stackcode.gestao.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Produto {

    @NotBlank(message="SKU é obrigatório")
    private String sku;
    
    @NotBlank(message="Nome é obrigatório")
    private String nome;
    
    @Size(min=3, max=50,message="O tamanho da descrição deve estar entre 1 e 50")
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
