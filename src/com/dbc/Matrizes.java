package com.dbc;

public class Matrizes {
    public static void main(String[] args) {
        int linha1;
        int linha2;
        int [][] matrizNumeros = new int[2][2];

        matrizNumeros [0][0] = 20;
        matrizNumeros [0][1] = 20;
        matrizNumeros [1][0] = 10;
        matrizNumeros [1][1] = 10;


        System.out.println(matrizNumeros[0][0] + matrizNumeros[0][1] + matrizNumeros[1][0] + matrizNumeros[1][1]);
        linha1 = matrizNumeros[0][0] + matrizNumeros [0][1];
        System.out.println(linha1);
        linha2 = matrizNumeros[1][0] + matrizNumeros [1][1];
        System.out.println(linha2);
        System.out.println(linha1-linha2);
    }
}
