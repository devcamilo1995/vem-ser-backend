package com.dbc.Lista2;

import java.util.Scanner;
//Faça um algoritmo que leia 20 valores e os escreva na ordem contrária à que foram
//digitados.

public class Exercicio5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[20];

        for(int i = 0; i < vetor.length; i++){
            System.out.println("Digite um número");
            vetor[i] = scanner.nextInt();
        }

        for(int i = vetor.length-1; i >= 0; i--){
            System.out.println(vetor[i]);
        }
    }
}
