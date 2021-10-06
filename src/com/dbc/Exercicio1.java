package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite um nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        String idade = scanner.nextLine();

        System.out.println("Digite sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Digite seu estado: ");
        String estado = scanner.nextLine();

        System.out.println("Olá seu nome é:"+nome + " voce tem: "+ idade + " anos,é da cidade de "+ cidade + ", situada no estado de "+estado +".");







    }
}
