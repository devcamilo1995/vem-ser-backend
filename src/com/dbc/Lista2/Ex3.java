package com.dbc.Lista2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //copia

        String nomeDoJogador = "";
        int quantidadeDePessoas = 0;
        double maiorJogador = 0;

        String jogadorMaisVelho = "";
        int idadeJogadorMaisVelho = 0;

        String jogadorMaisPesado = "";
        double pesoJogadorMaisPesado = 0;
        double somaAlturas = 0;

        while (!nomeDoJogador.equalsIgnoreCase("SAIR")) {
            System.out.println("digite o nome do jogador");
            nomeDoJogador = scanner.nextLine();
            if (nomeDoJogador.equalsIgnoreCase("sair")) {
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

            quantidadeDePessoas++;
            if (maiorJogador < alturaJogador) {
                maiorJogador = alturaJogador;
            }
            if (idadeJogadorMaisVelho < idade) {
                jogadorMaisVelho = nomeDoJogador;
                idadeJogadorMaisVelho = idade;
            }

            if (pesoJogadorMaisPesado < peso) {
                jogadorMaisPesado = nomeDoJogador;
                pesoJogadorMaisPesado = peso;
            }

            somaAlturas += alturaJogador;
        }

        System.out.println("Quantidade de jogadores cadastrados: " + quantidadeDePessoas);
        System.out.println("Altura do maior Jogador: " + maiorJogador);
        System.out.println("Jogador mais velho: " + jogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + jogadorMaisPesado);
        System.out.println("Média das alturas jogadores: " + somaAlturas / quantidadeDePessoas);

    }
}
