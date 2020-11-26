package com.ufcg.psoft.mercadofacil.model;

import com.ufcg.psoft.mercadofacil.enumTipos.TipoPagamento;
import exceptions.ObjetoInvalidoException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra {
    @OneToMany(cascade= CascadeType.PERSIST)
    private List<ProdutoComprado> produtos;

    private BigDecimal valortotal;
    private LocalDate registro;

    @Enumerated(value = EnumType.STRING)
    private TipoPagamento formaPagamento;

    @Transient
    private double somaValores;

    @Id
    @GeneratedValue
    private Long id;

    public Compra(){}

    public Compra(List<Produto> produtos, TipoPagamento formaPagamento) {
        this.produtos = new ArrayList<>();
        this.registro = LocalDate.now();
        this.somaValores = 0;
        this.formaPagamento = formaPagamento;
    }



    public void povoaArray(List<Produto> carrinho){
        boolean acres = false;
        for(Produto produto : carrinho){
            ProdutoComprado comprado = new ProdutoComprado(produto);
            if(!produtos.isEmpty()){
                for(ProdutoComprado prod : produtos){
                    if(prod.getProduto().equals(comprado.getProduto())){
                        prod.aumentaQtd();
                        acres = true;
                        break;
                    }
                }
            }

            somaValores += produto.getPreco().doubleValue();
            if(!acres){
                produtos.add(comprado);

            }
            acres = false;
        }
        valortotal = new BigDecimal(somaValores);
        somaValores = 0;
    }


    public void removeDoLote(List<ProdutoComprado> carrinho, List<Lote> lotes) throws ObjetoInvalidoException {
        for(Lote lote : lotes){
            for(ProdutoComprado produto : carrinho){
                if(lote.getProduto().equals(produto.getProduto())){
                    if(lote.getNumeroDeItens() - produto.getQuantidade() >= 0){
                        int novototal = 0;
                        novototal = lote.getNumeroDeItens() - produto.getQuantidade();
                        lote.setNumeroDeItens(novototal);
                    }else{
                        throw new ObjetoInvalidoException("Não há produtos suficientes no lote");
                    }

                }
            }
        }
    }

    public String geraRelatorio(){
        return "Compra realizada com sucesso";
    }

    private boolean onArray(List<ProdutoComprado> comprados, Produto prod){
        for(int i =0; i < comprados.size(); i++){
            if(comprados.get(i).getProduto().equals(prod)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }




    public List<ProdutoComprado> getProdutos() {
        return produtos;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public LocalDate getRegistro() {
        return registro;
    }

    public void setRegistro(LocalDate registro) {
        this.registro = registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPagamento getFormaPagamento() {
        return formaPagamento;
    }
}
