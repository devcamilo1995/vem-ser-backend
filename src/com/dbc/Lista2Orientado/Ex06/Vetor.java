package com.dbc.Lista2Orientado.Ex06;

import java.util.Scanner;

public class Vetor {
    Scanner scanner = new Scanner(System.in);
    private int[] vetor = new int[10];

    public void vetores() {
        vetor[0] = 9;
        vetor[1] = 8;
        vetor[2] = 7;
        vetor[3] = 5;
        vetor[4] = 5;
        vetor[5] = 4;
        vetor[6] = 3;
        vetor[7] = 2;
        vetor[8] = 1;
        vetor[9] = 9;
    }

    public void acharVetor() {
        System.out.println("Digite um valor para procurar no vetor");
        int num = scanner.nextInt();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num) {
                System.out.println("O índice do número digitado é " + i);
                break;
            } else if (i == vetor.length - 1) {
                System.out.println("Número não encontrado no vetor");
            }
        }
    }
}