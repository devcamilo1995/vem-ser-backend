package com.dbc.Lista1;

import java.util.Scanner;
//Crie um programa que calcule o salário do usuário, para isso será necessário passar o valor da hora em R$,
//o número de horas normais trabalhas, as horas extras (50%), e as horas extras trabalhadas (100%), em
//seguida exiba o salário bruto
public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float valorHoraNormal;
        double valorHoraExtra;
        double valorHoraExtraTrabalhada;

        System.out.println("Digite o valor das horas em R$: ");
        float valorHoraReais = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas normais: ");
        float horasNormais = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas extras: ");
        float horasExtras = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o numero de horas  extras trabalhadas: ");
        float horasExtrasTrabalhadas = Float.parseFloat(scanner.nextLine());

        valorHoraNormal = valorHoraReais * horasNormais;
        valorHoraExtra = (valorHoraReais * 1.5) * horasExtras;
        valorHoraExtraTrabalhada = (valorHoraReais *2) * horasExtrasTrabalhadas ;

        System.out.println("valor do salario: "+ (valorHoraNormal+valorHoraExtra+valorHoraExtraTrabalhada));
    }
}

