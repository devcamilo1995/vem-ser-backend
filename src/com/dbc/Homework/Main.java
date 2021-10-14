package com.dbc.Homework;


public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrenteMatheus = clienteUm();
        ContaCorrente contaCorrenteCamilo = clienteDois();

        contaCorrenteMatheus.imprimirContaCorrente();
        contaCorrenteCamilo.imprimirContaCorrente();

        contaCorrenteCamilo.transferir(contaCorrenteMatheus, 400);

        contaCorrenteMatheus.imprimirContaCorrente();
        contaCorrenteCamilo.imprimirContaCorrente();




    }

    public static ContaCorrente clienteUm() {
        Contato contato1 = new Contato();
        contato1.descricao = "teste";
        contato1.telefone = "0123";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "teste";
        contato2.telefone = "0123";
        contato2.tipo = 1;

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 2;
        endereco1.logradouro = "Siqueira";
        endereco1.numero = 484;
        endereco1.cep = "12504010";
        endereco1.complemento = "teste";
        endereco1.cidade = "Guara";
        endereco1.estado = "SP";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 1;
        endereco2.logradouro = "Campos";
        endereco2.numero = 844;
        endereco2.cep = "12502010";
        endereco2.complemento = "teste2";
        endereco2.cidade = "Guara";
        endereco2.estado = "SP";
        endereco2.pais = "Brasil";

        Cliente clienteMatheus = new Cliente();
        clienteMatheus.cpf = "123";
        clienteMatheus.nome = "Matheus";
        clienteMatheus.enderecos[0] = endereco1;
        clienteMatheus.enderecos[1] = endereco2;
        clienteMatheus.contatos[0] = contato1;
        clienteMatheus.contatos[1] = contato2;

        ContaCorrente contaCorrenteMatheus = new ContaCorrente();
        contaCorrenteMatheus.cliente = clienteMatheus;
        contaCorrenteMatheus.numeroConta = "123";
        contaCorrenteMatheus.agencia = "100";
        contaCorrenteMatheus.chequeEspecial = 2000.0;
        contaCorrenteMatheus.saldo = 0;

        contaCorrenteMatheus.depositar(1500);
        return contaCorrenteMatheus;
    }

    public static ContaCorrente clienteDois() {
        Contato contato1 = new Contato();
        contato1.descricao = "teste2";
        contato1.telefone = "01234";
        contato1.tipo = 2;

        Contato contato2 = new Contato();
        contato2.descricao = "teste3";
        contato2.telefone = "012123";
        contato2.tipo = 1;

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 2;
        endereco1.logradouro = "Siqueira";
        endereco1.numero = 484;
        endereco1.cep = "12504010";
        endereco1.complemento = "teste";
        endereco1.cidade = "Guara";
        endereco1.estado = "SP";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 1;
        endereco2.logradouro = "Campos";
        endereco2.numero = 844;
        endereco2.cep = "12502010";
        endereco2.complemento = "teste2";
        endereco2.cidade = "Guara";
        endereco2.estado = "SP";
        endereco2.pais = "Brasil";

        Cliente clienteCamilo = new Cliente();
        clienteCamilo.cpf = "321";
        clienteCamilo.nome = "Camilo";
        clienteCamilo.enderecos[0] = endereco1;
        clienteCamilo.enderecos[1] = endereco2;
        clienteCamilo.contatos[0] = contato1;
        clienteCamilo.contatos[1] = contato2;

        ContaCorrente contaCorrenteCamilo = new ContaCorrente();
        contaCorrenteCamilo.cliente = clienteCamilo;
        contaCorrenteCamilo.numeroConta = "123";
        contaCorrenteCamilo.agencia = "100";
        contaCorrenteCamilo.chequeEspecial = 4000.0;
        contaCorrenteCamilo.saldo = 0;

        contaCorrenteCamilo.depositar(1500);
        return contaCorrenteCamilo;


    }

}

