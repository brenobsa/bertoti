package org.example;



import java.util.ArrayList;

public class HomologacaoVeiculos {

    public static void main(String[] args) {

        ArrayList<Veiculo> bancoFake = new ArrayList<>();

        bancoFake.add(new Veiculo("Honda Civic", "ABC-1234"));
        bancoFake.add(new Veiculo("Toyota Corolla", "DEF-5678"));
        bancoFake.add(new Veiculo("Volkswagen Gol", "GHI-9012"));

        System.out.println("Verificando quantidade de veículos...");

        if (bancoFake.size() == 3) {

            System.out.println("Sucesso: 3 veículos cadastrados.");

        } else {

            System.out.println("Falha na contagem.");

        }

        String busca = "Toyota Corolla";

        boolean encontrado = false;

        for (Veiculo v : bancoFake) {

            if (v.getModelo().equals(busca)) {

                encontrado = true;

                System.out.println(
                        "Sucesso: Veículo encontrado."
                );

                break;
            }
        }

        if (!encontrado) {

            System.out.println(
                    "Falha: Veículo não encontrado."
            );

        }
    }
}