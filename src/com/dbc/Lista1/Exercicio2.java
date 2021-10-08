package com.dbc.Lista1;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        float nota1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a segunda nota: ");
        float nota2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a terceira nota: ");
        float nota3 = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quarta nota: ");
        float nota4 = Integer.parseInt(scanner.nextLine());

        float media = (nota1+nota2+nota3+nota4)/4;
        System.out.println("Media do aluno: "+media);

        if (media <= 5){
            System.out.println("Reprovado");
        } else if (media <=6.9) {
            System.out.println("Em exame");
        }else
            System.out.println("Aprovado");
        }
    }

