package com.dbc.Lista2Orientado.Ex03;

import java.util.Scanner;

public class Jogador {
    private String nome = "";
    private int quantidade = 0;
    private double maiorJogador = 0;
    private String jogadorMaisVelho = "";
    private int idadeJogadorMaisVelho = 0;
    private String jogadorMaisPesado = "";
    private double pesoJogadorMaisPesado = 0;
    private double somaAlturas = 0;

    Scanner scanner = new Scanner(System.in);

    public void jogador() {
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
