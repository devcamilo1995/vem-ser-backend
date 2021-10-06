package com.dbc;

import java.util.Scanner;

public class Vetores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de elementos desejada: ");
        int elementos = scanner.nextInt();
        int[] vetor = new int[elementos];

        int soma = 0;


        for (int i = 0; i < vetor.length; i++) {
            System.out.println("valor elemento: " + i);
            vetor[i] = scanner.nextInt();
            soma += vetor[i];
        }
        double media = soma / vetor.length;
        System.out.println("media: " + media);
    }
}
