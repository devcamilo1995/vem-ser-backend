package com.dbc.Lista2Orientado.Ex05;

import java.util.Scanner;

public class Valores {
    Scanner scanner = new Scanner(System.in);

    int[] vetor = new int[20];

    public void calcular(){
        for(int i = 0; i < vetor.length; i++){
            System.out.println("Digite um número");
            vetor[i] = scanner.nextInt();
        }

        for(int i = vetor.length-1; i >= 0; i--){
            System.out.println(vetor[i]);
        }
    }
}

