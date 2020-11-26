
package com.ufcg.psoft.mercadofacil.model;




import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class Carrinho{
    private List<Produto> produtos;
    private int qtd;




    public Carrinho(List<Produto> produtos) {
        this.produtos = new ArrayList<Produto>();
    }

    public Produto addProdutoCarrinho(Produto prod){
        this.produtos.add(prod);
        return prod;

    }

    public void esvaziaCarrinho(){
        this.produtos = new ArrayList<Produto>();
    }


    public List<Produto> exibirCarrinho(){
        return this.produtos;
    }




    public void setValortotal(BigDecimal valortotal) {
        valortotal = valortotal;
    }



    @Override
    public String toString() {
        return "Carrinho{" +
                "Produtos=" + produtos +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(produtos);
    }
}
