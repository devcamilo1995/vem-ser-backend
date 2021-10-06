package com.dbc;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra que queira traduzir: ");
        String palavra = scanner.nextLine();

        switch (palavra) {
            case "Cachorro" -> System.out.println("Em inglês é Dog");
            case "Tempo" -> System.out.println("Em inglês é Time");
            case "Amor" -> System.out.println("Em inglês é Love");
            case "Cidade" -> System.out.println("Em inglês é City");
            case "Feliz" -> System.out.println("Em inglês é Happy");
            default -> System.out.println("Essa palavra não é válida");
        }
    }
}