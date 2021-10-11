package com.dbc.Lista1;

import java.util.Scanner;
//Desenvolver um algoritmo que exiba as seguintes informações, porém o que está sublinhado será
//solicitado ao usuário (por meio do Scanner).
//EXEMPLO: Olá seu nome é João, você tem 16 anos, é da cidade de Florianópolis, situada
//no estado de Santa Catarina.

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite um nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Digite seu estado: ");
        String estado = scanner.nextLine();

        System.out.println("Olá seu nome é:"+nome + " voce tem: "+ idade + " anos,é da cidade de "+ cidade + ", situada no estado de "+estado +".");







    }
}
