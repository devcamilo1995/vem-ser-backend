package com.dbc.Lista2;

import java.text.DecimalFormat;
import java.util.Scanner;
//Elabore um programa para uma papelaria que leia o nome e o valor de um produto.
//Em seguida, faça uma lista de 1 a 10 unidades do produto, sendo que o desconto de
//uma unidade desse produto seja de 5% e de 2 seja 10% de 3 = 15% etc... Até
//alcançar os 50% de desconto

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String nome = scanner.next();
        System.out.println("Digite o valor: ");
        float valor = scanner.nextFloat();

        System.out.println("Nome do produto: " + nome);
        System.out.println("Valor: " + valor);
        System.out.println("Promoção: ");

        double desconto =0.05;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);
        for (int i = 1; i <= 10; i++){
        double precoDesconto = valor - (valor * desconto);

            System.out.println(i + "x R$ " + df.format(precoDesconto) + " R$ " + df.format(i* precoDesconto));
                    desconto += 0.05;

        }





    }
}
