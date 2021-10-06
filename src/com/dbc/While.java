package com.dbc;

import java.util.Objects;
import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra (fim para finalizar");
        String palavra = scanner.nextLine();


        while (!Objects.equals(palavra, "fim")) {
            System.out.println(palavra);
            palavra = scanner.nextLine();
        }
        System.out.println("finalizado");

    }
}
