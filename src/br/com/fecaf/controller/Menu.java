package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;
import br.com.fecaf.model.Conta;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    Conta referenciaConta = new Conta();
    Cliente referenciaCliente = new Cliente();


    public void executarMenu() {

        boolean exit = false;

        while(!exit) {
            System.out.println("/------------------------------------/");
            System.out.println("/------------ Banco FECAF -----------/");
            System.out.println("/------------------------------------/");
            System.out.println("/ 1 - Login                          /");
            System.out.println("/ 2 - Criar Conta                    /");
            System.out.println("/ 3 - Sair                           /");
            System.out.println("/------------------------------------/");

            System.out.println("Escolha uma opção: ");
            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption){
                case 1:
                        Login login = new Login();
                        Conta contaCliente = login.realizarLogin(referenciaConta, referenciaCliente);

                        if (contaCliente != null){
                            acessarConta(contaCliente);
                        }

                    break;
                case 2:

                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    cliente.exibirInformacoes();

                    Conta conta = new Conta();
                    conta.criarConta(cliente);
                    conta.exibirPerfil();

                    referenciaCliente.adicionarClienteList(cliente);
                    referenciaConta.adicionarContaList(conta);

                    break;

                case 3:
                    System.out.println("Saindo...");
                    exit = true;
                    break;

                default:
                    System.out.println("Escolha uma opção válida !");
            }


        }

    }


    public void acessarConta (Conta conta) {

        boolean exitConta = false;

        while (!exitConta) {
            conta.exibirPerfil();

            System.out.println("/---------------------------------------/");
            System.out.println("/------------  Menu Conta --------------/");
            System.out.println("/---------------------------------------/");
            System.out.println("/ 1 - Consultar Saldo                   /");
            System.out.println("/ 2 - Realizar Deposito                 /");
            System.out.println("/ 3 - Realizar Saque                    /");
            System.out.println("/ 4 - Realizar Transferencia            /");
            System.out.println("/ 5 - Sair                              /");
            System.out.println("/---------------------------------------/");

            int userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    System.out.println("/------- Deposito ---------/");
                    System.out.print("Informe o Valor para Deposito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    conta.realizarDeposito(valorDeposito);
                    conta.consultarSaldo();

                    break;

                case 3:
                    System.out.println("/------- Saque ---------/");
                    System.out.print("Informe o Valor para Deposito: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();

                    conta.realizarSaque(valorSaque);
                    conta.consultarSaldo();

                    break;

                case 4:
                    System.out.println("Feature in Development !");
                    break;
                case 5:
                    exitConta = true;
                    break;

                default:
                    System.out.println("Escolha uma opção válida!");
            }
        }



    }

}
