package com.dbc.Lista2;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Desenvolver um algoritmo que peça nome, altura, idade, peso dos jogadores de
        //basquete, enquanto o nome do jogador for diferente da palavra SAIR o programa
        //deverá pedir essas informações, após cadastrados deverá aparecer as seguintes
        //informações:
        //Quantidade de jogadores cadastrados;
        //Altura do maior Jogador;
        //Jogador mais velho;
        //Jogador mais pesado;
        //Média das alturas jogadores.

        String nome= "";
        int quantidade = 0;
        double maiorJogador = 0;
        String jogadorMaisVelho = "";
        int idadeJogadorMaisVelho = 0;
        String jogadorMaisPesado = "";
        double pesoJogadorMaisPesado = 0;
        double somaAlturas = 0;

        while (!nome.equalsIgnoreCase("SAIR")) {
            System.out.println("digite o nome do jogador");
            nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.println("digite a altura do jogador");
            double alturaJogador = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("digite o peso do jogador");
            double peso = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("digite a idade do jogador");
            int idade = scanner.nextInt();
            scanner.nextLine();

            quantidade++;
            if (maiorJogador < alturaJogador) {
                maiorJogador = alturaJogador;
            }
            if (idadeJogadorMaisVelho < idade) {
                jogadorMaisVelho = nome;
                idadeJogadorMaisVelho = idade;
            }

            if (pesoJogadorMaisPesado < peso) {
                jogadorMaisPesado = nome;
                pesoJogadorMaisPesado = peso;
            }

            somaAlturas += alturaJogador;
        }

        System.out.println("Quantidade de jogadores cadastrados: " + quantidade);
        System.out.println("Altura do maior Jogador: " + maiorJogador);
        System.out.println("Jogador mais velho: " + jogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + jogadorMaisPesado);
        System.out.println("Média das alturas jogadores: " + somaAlturas / quantidade);

    }
}
