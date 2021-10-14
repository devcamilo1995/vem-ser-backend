package com.dbc.Homework2;

public class ContaPoupanca extends Conta implements Impressao {
    final static double JUROS_MENSAL = 1.01;


    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);


    }


    @Override
    public boolean sacar(double valorSaque) {
        if(valorSaque > this.getSaldo()){
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            this.setSaldo(this.getSaldo()-valorSaque);
                System.out.println("Saque feito com sucesso");
            return true;
        }
    }

    @Override
    public boolean depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            System.out.println("impossivel");
            return false;
        } else {
            this.setSaldo(this.getSaldo() + valorDeposito);
            System.out.println("Deposito feito com sucesso");
            return true;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Valor do saldo: " + this.getSaldo());

    }
}

