package com.dbc.Aula5;

public class Main {
    public static void main(String[] args) {
        Gato amarelo = new Gato("amarelo","viralata");
        System.out.println(amarelo.getNome());
        System.out.println(amarelo.getRaca());
        System.out.println(amarelo.mia());

        Cachorro viraLata = new Cachorro("Adonis","border");
        System.out.println(viraLata.getNome());
        System.out.println(viraLata.getRaca());
        System.out.println(viraLata.late());
    }
}
