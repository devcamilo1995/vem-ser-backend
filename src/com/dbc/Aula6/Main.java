package com.dbc.Aula6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tipo;
        System.out.println("Digite um tipo de comida: 0 - Japonesa , 1 - Fast Food, 2 - Tradicional");
        tipo = scanner.nextInt();
        if (tipo == 0) {
            System.out.println(tipoComida.JAPONESA.getDescricao());
        }
        else if (tipo == 1) {
            System.out.println(tipoComida.FASTFOOD.getDescricao());
        }
        else if (tipo == 2) {
            System.out.println(tipoComida.TRADICIONAL.getDescricao());
        } else {
            System.out.println("Numero invalido");

        }
    }
}

