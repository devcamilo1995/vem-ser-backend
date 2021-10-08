package com.dbc.Lista1;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um estado: SP, RJ, MG");
        String estado = scanner.nextLine();

        if ("SP".equals(estado)) {
            System.out.println("Escolha uma cidade: Aparecida, Lorena");
            String cidade = scanner.nextLine();

            switch (cidade) {
                case "Aparecida" -> {
                    System.out.println("100 mil habitantes");
                    System.out.println("Melhor festa: Festa da Padroeira");
                    System.out.println("IDH de 20%");
                }
                case "Lorena" -> {
                    System.out.println("150 mil habitantes");
                    System.out.println("Melhor festa: Festa de Lorena");
                    System.out.println("IDH de 25%");
                }
            }
        }
        if ("RJ".equals(estado)) {
            System.out.println("Escolha uma cidade: Rezende, Cabo Frio");
            String cidade = scanner.nextLine();

            switch (cidade) {
                case "Rezende" -> {
                    System.out.println("200 mil habitantes");
                    System.out.println("Melhor festa: Festa da Boi");
                    System.out.println("IDH de 30%");
                }
                case "Cabo Frio" -> {
                    System.out.println("250 mil habitantes");
                    System.out.println("Melhor festa: Festa da Praia");
                    System.out.println("IDH de 35%");
                }
            }
        }
        if ("MG".equals(estado)) {
            System.out.println("Escolha uma cidade: Passa Quatro, Virginia");
            String cidade = scanner.nextLine();


            switch (cidade) {
                case "Passa Quatro" -> {
                    System.out.println("400 mil habitantes");
                    System.out.println("Melhor festa: Festa do Queijo");
                    System.out.println("IDH de 10%");
                }
                case "Virginia" -> {
                    System.out.println("50 mil habitantes");
                    System.out.println("Melhor festa: Festa da Laranja");
                    System.out.println("IDH de 5%");
                }
            }
        }
        else System.out.println("Erro de digitação");
    }
}