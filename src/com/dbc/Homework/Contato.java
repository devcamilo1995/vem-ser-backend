package com.dbc.Homework;

public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
