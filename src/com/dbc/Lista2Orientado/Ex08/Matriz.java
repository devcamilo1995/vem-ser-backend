package com.dbc.Lista2Orientado.Ex08;

import java.util.Scanner;

public class Matriz {
    private int[][] matriz = new int[5][4];
    private int somaDasNotasFinais = 0;
    private int maiorNotaFinal = Integer.MIN_VALUE;
    private int matriculaMaiorNotaFinal = 0;

    Scanner scanner = new Scanner(System.in);

    public void lerMatriz() {
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


