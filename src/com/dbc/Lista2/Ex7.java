package com.dbc.Lista2;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int maior10 = 0;

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
