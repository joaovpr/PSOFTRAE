package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProdutoComprado {
    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    private Produto produto;

    private int quantidade;
    private BigDecimal preco;

    public ProdutoComprado(){}

    public ProdutoComprado(Produto produto) {
        this.quantidade = 1;
        this.produto = produto;
        this.preco = produto.getPreco();

    }

    public void aumentaQtd(){this.quantidade++;}

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
