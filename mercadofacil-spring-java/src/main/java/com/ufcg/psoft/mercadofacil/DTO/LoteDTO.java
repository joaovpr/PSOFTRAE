package com.ufcg.psoft.mercadofacil.DTO;

public class LoteDTO {

    private int numeroDeItens;
    private String validade;

    public LoteDTO() {
    }

    public LoteDTO(int numeroDeItens, String validade) {
        super();
        this.numeroDeItens = numeroDeItens;
        this.validade = validade;
    }

    public int getNumeroDeItens() {
        return numeroDeItens;
    }

    public void setNumeroDeItens(int numeroDeItens) {
        this.numeroDeItens = numeroDeItens;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
