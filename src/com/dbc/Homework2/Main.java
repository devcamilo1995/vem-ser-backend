package com.dbc.Homework2;

public class Main {
    public static void main(String[] args) {
        Contato clienteUmContato1 = new Contato();
        clienteUmContato1.setDescricao("whats");
        clienteUmContato1.setTelefone("12981117598");
        clienteUmContato1.setTipo(1);

        Contato clienteUmContato2 = new Contato();
        clienteUmContato2.setDescricao("whats");
        clienteUmContato2.setTelefone("12997059031");
        clienteUmContato2.setTipo(2);

        Endereco clienteUmEndereco1 = new Endereco();
        clienteUmEndereco1.setTipo(1);
        clienteUmEndereco1.setLogradouro("Siqueira Campos");
        clienteUmEndereco1.setNumero(484);
        clienteUmEndereco1.setComplemento("Nenhum");
        clienteUmEndereco1.setCep("12504-010");
        clienteUmEndereco1.setCidade("Guaratingueta");
        clienteUmEndereco1.setEstado("Sao Paulo");
        clienteUmEndereco1.setPais("Brasil");

        Endereco clienteUmEndereco2 = new Endereco();
        clienteUmEndereco2.setTipo(2);
        clienteUmEndereco2.setLogradouro("Campos");
        clienteUmEndereco2.setNumero(584);
        clienteUmEndereco2.setComplemento("Nenhum");
        clienteUmEndereco2.setCep("12504-010");
        clienteUmEndereco2.setCidade("Guaratingueta");
        clienteUmEndereco2.setEstado("Sao Paulo");
        clienteUmEndereco2.setPais("Brasil");

        Cliente clienteUm = new Cliente();
        clienteUm.setNome("Matheus Camilo");
        clienteUm.setCpf("412868118-05");
        clienteUm.getEnderecos ()[0]= new Endereco();
        clienteUm.getEnderecos ()[1]= new Endereco();
        clienteUm.getContatos()[0] = new Contato();
        clienteUm.getContatos()[1] = new Contato();

        ContaPagamento contaPagamentoClienteUm = new ContaPagamento();
        contaPagamentoClienteUm.setCliente(clienteUm);
        contaPagamentoClienteUm.setSaldo(5000);
        contaPagamentoClienteUm.setNumeroConta("123");
        contaPagamentoClienteUm.setAgencia("001");

        ContaCorrente contaCorrenteClienteUm = new ContaCorrente();
        contaCorrenteClienteUm.setCliente(clienteUm);
        contaCorrenteClienteUm.setNumeroConta("321");
        contaCorrenteClienteUm.setSaldo(5000);
        contaCorrenteClienteUm.setAgencia("123");
        contaCorrenteClienteUm.setChequeEspecial(5000);





        Contato clienteDoisContato1 = new Contato();
        clienteDoisContato1.setDescricao("whats");
        clienteDoisContato1.setTelefone("1298880000");
        clienteDoisContato1.setTipo(1);

        Contato clienteDoisContato2 = new Contato();
        clienteDoisContato2.setDescricao("whats");
        clienteDoisContato2.setTelefone("1299999999");
        clienteDoisContato2.setTipo(2);

        Endereco clienteDoisEndereco1 = new Endereco();
        clienteDoisEndereco1.setTipo(1);
        clienteDoisEndereco1.setLogradouro("Siqueira");
        clienteDoisEndereco1.setNumero(684);
        clienteDoisEndereco1.setComplemento("Nenhum");
        clienteDoisEndereco1.setCep("12504-010");
        clienteDoisEndereco1.setCidade("Guaratingueta");
        clienteDoisEndereco1.setEstado("Sao Paulo");
        clienteDoisEndereco1.setPais("Brasil");

        Endereco clienteDoisEndereco2 = new Endereco();
        clienteDoisEndereco2.setTipo(2);
        clienteDoisEndereco2.setLogradouro("Vasco");
        clienteDoisEndereco2.setNumero(784);
        clienteDoisEndereco2.setComplemento("Nenhum");
        clienteDoisEndereco2.setCep("12504-010");
        clienteDoisEndereco2.setCidade("Guaratingueta");
        clienteDoisEndereco2.setEstado("Sao Paulo");
        clienteDoisEndereco2.setPais("Brasil");

        Cliente clienteDois = new Cliente();
        clienteDois.setNome("Camilo");
        clienteDois.setCpf("412868118-05");
        clienteDois.getEnderecos ()[0]= new Endereco();
        clienteDois.getEnderecos ()[1]= new Endereco();
        clienteDois.getContatos()[0] = new Contato();
        clienteDois.getContatos()[1] = new Contato();

        ContaPoupanca contaPoupancaClienteDois = new ContaPoupanca();
        contaPoupancaClienteDois.setSaldo(10000);
        contaPoupancaClienteDois.setCliente(clienteDois);
        contaPoupancaClienteDois.setNumeroConta("532");
        contaPoupancaClienteDois.setAgencia("321");


        contaCorrenteClienteUm.transferir(contaPoupancaClienteDois,1000);


        contaPagamentoClienteUm.sacar(500);



        contaPoupancaClienteDois.depositar(1000);

        contaPagamentoClienteUm.imprimir();
        contaCorrenteClienteUm.imprimir();
        contaPoupancaClienteDois.imprimir();

//        contaPoupancaClienteDois.creditarTaxa();
//        contaPoupancaClienteDois.imprimir();
//
//        contaCorrenteClienteUm.sacar(7000);
//        contaCorrenteClienteUm.imprimir();
    }
}
