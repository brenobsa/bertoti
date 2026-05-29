package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class ControleVeiculos {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();

        int opcao = 0;

        System.out.println("=== Sistema de Controle de Veículos ===");

        do {

            System.out.println("\n1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Realizar Manutenção");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Modelo do veículo: ");
                    String modelo = leitor.nextLine();

                    System.out.print("Placa do veículo: ");
                    String placa = leitor.nextLine();

                    listaVeiculos.add(new Veiculo(modelo, placa));

                    System.out.println("Veículo cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.println("\n=== Lista de Veículos ===");

                    if (listaVeiculos.isEmpty()) {

                        System.out.println("Nenhum veículo cadastrado.");

                    } else {

                        for (int i = 0; i < listaVeiculos.size(); i++) {

                            System.out.println(i + ". " + listaVeiculos.get(i));

                        }

                    }

                    break;

                case 3:

                    if (listaVeiculos.isEmpty()) {

                        System.out.println("Nenhum veículo cadastrado.");
                        break;

                    }

                    System.out.print("Digite o índice do veículo: ");
                    int indice = leitor.nextInt();

                    if (indice >= 0 && indice < listaVeiculos.size()) {

                        Veiculo veiculo = listaVeiculos.get(indice);

                        if (veiculo.isPrecisaManutencao()) {

                            veiculo.setPrecisaManutencao(false);

                            System.out.println(
                                    veiculo.getModelo()
                                            + " passou pela manutenção."
                            );

                        } else {

                            System.out.println(
                                    "Este veículo já está com a manutenção em dia."
                            );

                        }

                    } else {

                        System.out.println("Veículo não encontrado.");

                    }

                    break;

                case 4:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while (opcao != 4);

        leitor.close();
    }
}
