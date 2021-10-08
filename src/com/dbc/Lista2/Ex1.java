package com.dbc.Lista2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex1 {
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
