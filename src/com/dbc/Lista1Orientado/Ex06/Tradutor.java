package com.dbc.Lista1Orientado.Ex06;

import java.util.Scanner;

public class Tradutor {
    private String palavra;

    Scanner scanner = new Scanner(System.in);

    public void traduzir() {
        System.out.println("Digite uma palavra que queira traduzir: ");
        palavra = scanner.nextLine();

        switch (palavra) {
            case "Cachorro" -> System.out.println("Em inglês é Dog");
            case "Tempo" -> System.out.println("Em inglês é Time");
            case "Amor" -> System.out.println("Em inglês é Love");
            case "Cidade" -> System.out.println("Em inglês é City");
            case "Feliz" -> System.out.println("Em inglês é Happy");
            case "Dog" -> System.out.println("Em português é Cachorro");
            case "Time" -> System.out.println("Em português é Tempo");
            case "Love" -> System.out.println("Em português é Amor");
            case "City" -> System.out.println("Em português é Cidade");
            case "Happy" -> System.out.println("Em português é Feliz");
            default -> System.out.println("Essa palavra não é válida");
        }
    }
}
