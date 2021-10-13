package com.dbc.Lista1Orientado.Ex01;

import java.util.Scanner;

public class Pessoa {

    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    Scanner scanner = new Scanner(System.in);

    public void imprimir (){
        System.out.println("Digite o nome");
        nome = scanner.next();
        System.out.println("Digite a idade");
        idade = scanner.nextInt();
        System.out.println("Digite a cidade");
        cidade = scanner.next();
        System.out.println("Digite o estado");
        estado = scanner.next();

        System.out.println(nome + idade + cidade +estado);
    }
}
