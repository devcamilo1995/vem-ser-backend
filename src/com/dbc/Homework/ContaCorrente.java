package com.dbc.Homework;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    String agencia;
    double saldo;
    double chequeEspecial;


    public void imprimirContaCorrente(){
        System.out.println(this);
    }
public boolean sacar (double valor){
         if (valor > (saldo + chequeEspecial)) {
             System.out.println("Saldo e cheque especial insuficientes para realizar o saque.");
             return false;
         } else {
             saldo -= valor;
         }
         return true;
}
 public boolean depositar(double valor) {
        if (valor <=0){
            System.out.println("impossivel");
            return false;
        } else {
            saldo +=valor;
        }
        return true;
 }
    public double retornarSaldoCompleto() {
        return saldo + chequeEspecial;
    }

    public void transferir(ContaCorrente contaCorrente, double valor) {
        boolean conseguiuSacar = sacar(valor);
        boolean conseguiuDepositar = false;
        if (conseguiuSacar) {
            conseguiuDepositar = contaCorrente.depositar(valor);
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + cliente +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
