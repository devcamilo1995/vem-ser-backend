package com.dbc.Lista2Orientado.Ex07;

import java.util.Scanner;

public class Matriz {
    Scanner scanner = new Scanner(System.in);
    private int[][] matriz = new int[4][4];
    private int maior10 = 0;

    public void lerMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int c = 0; c < matriz.length; c++) {
                System.out.print("Insira a posição [" + i + "][" + c + "]: ");
                matriz[i][c] = scanner.nextInt();


                if (matriz[i][c] > 10) {
                    maior10 += 1;

                }

            }

        }
        System.out.println("A matriz possui " + maior10 + " valores maiores do que 10.");
    }
}