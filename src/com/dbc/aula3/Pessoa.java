package com.dbc.aula3;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public void conversar(Pessoa pessoa, String mensagem){
        System.out.println("a pessoa " + this.nome + mensagem + " com " + pessoa.nome);
    }
}
