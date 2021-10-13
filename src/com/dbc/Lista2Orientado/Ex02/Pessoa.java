package com.dbc.Lista2Orientado.Ex02;

import java.util.Scanner;

public class Pessoa {
    private double numero1;
    private double numero2;
    Scanner scanner = new Scanner(System.in);



    public void acertarNumero(){

        System.out.println("Digite um numero: ");
        double numero1 = scanner.nextDouble();

        double numero2 = Integer.MIN_VALUE;

        while (numero1 != numero2){
            System.out.println("Tente acertar o numero: ");
            numero2 = scanner.nextDouble();

            if (numero1 < numero2) {
                System.out.println("O número a ser encontrado é menor do que você digitou \n");
            }
            else if (numero1 > numero2) {
                System.out.println("O número a ser encontrado é maior do que você digitou.\n");
            }
        }
        System.out.println("Voce acertou");
    }
}


