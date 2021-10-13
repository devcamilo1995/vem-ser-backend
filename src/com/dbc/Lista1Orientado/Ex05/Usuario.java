package com.dbc.Lista1Orientado.Ex05;

import java.util.Scanner;

public class Usuario {
    private double valorHoraNormal;
    private double valorHoraExtra;
    private double valorHoraExtraTrabalhada;
    private float valorHoraReais;
    private float horasNormais;
    private float horasExtras;
    private float horasExtrasTrabalhadas;

    Scanner scanner = new Scanner(System.in);

    public void calcularSalario(){
        System.out.println("Digite o valor das horas em R$: ");
        valorHoraReais = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas normais: ");
        horasNormais = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas extras: ");
        horasExtras = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas  extras trabalhadas: ");
        horasExtrasTrabalhadas = Float.parseFloat(scanner.nextLine());

        valorHoraNormal = valorHoraReais * horasNormais;
        valorHoraExtra = (valorHoraReais * 1.5) * horasExtras;
        valorHoraExtraTrabalhada = (valorHoraReais * 2) * horasExtrasTrabalhadas;

        System.out.println("valor do salario: " + (valorHoraNormal + valorHoraExtra + valorHoraExtraTrabalhada));

    }
}
