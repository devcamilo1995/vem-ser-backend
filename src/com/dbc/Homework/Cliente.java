package com.dbc.Homework;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void imprimirCliente() {
        System.out.println(this);
        imprimirContatos();
        imprimirEnderecos();
    }

    public void imprimirContatos() {
        for (Contato contato : contatos) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : enderecos) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}



