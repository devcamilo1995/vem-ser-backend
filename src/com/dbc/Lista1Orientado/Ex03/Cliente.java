package com.dbc.Lista1Orientado.Ex03;

import java.util.Scanner;

public class Cliente {
    private float valorConsumido;
    private float valorCliente;

    Scanner scanner = new Scanner(System.in);

    public void calcularTroco() {
        System.out.println("Digite o valor consumido: ");
        valorConsumido = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o valor pago pelo cliente: ");
        valorCliente = Float.parseFloat(scanner.nextLine());

        if (valorCliente < valorConsumido) {
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        }
        if (valorCliente >= valorConsumido) {
            System.out.println("Seu troco é: " + (valorCliente - valorConsumido));
        }

    }
}
