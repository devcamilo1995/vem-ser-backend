package com.dbc.Lista1;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor consumido: ");
        float valorConsumido = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o valor pago pelo cliente: ");
        float valorCliente = Float.parseFloat(scanner.nextLine());

        if (valorCliente < valorConsumido) {
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        }if (valorCliente >= valorConsumido){
            System.out.println("Seu troco é: "+ (valorCliente - valorConsumido));
        }

    }
    }