package com.dbc.Aula5.ex2;

public class Main {
    public static void main(String[] args) {
        Soma soma = new Soma();
        System.out.println(soma.calcula(1, 2));

        Subtracao subtracao = new Subtracao();
        System.out.println(subtracao.calcula(5, 2));

        Multiplicacao multiplicacao = new Multiplicacao();
        System.out.println(multiplicacao.calcula(5, 2));

        Divisao divisao = new Divisao();
        System.out.println(divisao.calcula(10,2));
    }
}