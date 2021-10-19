package com.dbc.Aula6;

public enum tipoComida {
    JAPONESA("Japonesa R$50,00"),
    FASTFOOD("Fast Food R$30,00"),
    TRADICIONAL("Tradicional R$20,00");

    private String descricao;


        tipoComida(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
