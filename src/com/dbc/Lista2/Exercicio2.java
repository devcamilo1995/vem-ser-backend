package com.dbc.Lista2;

import java.util.Scanner;
//Isso lembrará uma brincadeira de colégio...Uma pessoa escolhe um número e pede
//para outro adivinhar, faça um programa que tenha a mesma ideia, você informará um
//número e quando alguém for tentar adivinhá-lo o programa deverá informar se
//acertou o número ou se errou, se errou o programa deverá apresentar uma das
//seguintes frases: O número a ser encontrado é menor do que você digitou ou O
//número a ser encontrado é maior do que você digitou.
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

