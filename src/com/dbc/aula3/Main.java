package com.dbc.aula3;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Matheus";
        pessoa1.sobrenome = "Camilo";
        pessoa1.idade = 26;
        pessoa1.whatsapp = "12981117598";

        Pessoa pessoa2 = new Pessoa();
        pessoa2.nome = "João";
        pessoa2.sobrenome = "Paulo";
        pessoa2.idade = 25;
        pessoa2.whatsapp = "12997059031";

        pessoa1.conversar(pessoa2, " conversou ");
    }
}
