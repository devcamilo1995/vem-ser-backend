package com.dbc.Lista1;

import java.util.Scanner;

//Uma lanchonete precisa de um programa calcule o troco a ser dado para o cliente:
//a. Precisamos de 2 entradas: Valor total consumido e valor pago pelo cliente
//b. Se o valor pago for menor do que o total consumido deve exibir uma mensagem: “o valor pago
//deve ser maior ou igual ao valor consumido”
//c. Se o valor pago for menor ou igual ao total consumido, calcular o troco ao cliente

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