package com.dbc.Lista2;

import java.util.Scanner;



//Faça um programa que leia uma matriz de 5x4 inteiros contendo as seguintes
//informações do tipo inteiro:
//a. Primeira coluna: número da matrícula
//b. Segunda coluna: media das provas
//c. Terceira coluna: média dos trabalhos
//d. Quarta coluna: nota final
//Elabore um programa que:
//a. Leia as 3 primeiras informações de cada aluno
//b. Calcule a nota final = (media das provas * 0,6 + media dos trabalhos * 0,4)
//c. Imprima a matrícula que obteve a maior nota final
//d. Imprima a média das notas finai

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[5][4];
        int somaDasNotasFinais = 0;
        int maiorNotaFinal = Integer.MIN_VALUE;
        int matriculaMaiorNotaFinal = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Numero da matrícula");
            matriz[i][0] = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Média das provas");
            matriz[i][1] = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Média das média dos trabalhos");
            matriz[i][2] = scanner.nextInt();
            scanner.nextLine();

            matriz[i][3] = (int) ((matriz[i][1] * 0.6) + (matriz[i][2] * 0.4));
            if (matriz[i][3] > maiorNotaFinal) {
                maiorNotaFinal = matriz[i][3];
                matriculaMaiorNotaFinal = matriz[i][0];
            }

            somaDasNotasFinais += matriz[i][3];
        }

        System.out.println("matrícula com maior nota final: " + matriculaMaiorNotaFinal);
        System.out.println("média das notas finais: " + somaDasNotasFinais / 5);
    }
}
