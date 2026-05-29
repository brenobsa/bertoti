package org.example;

public class Veiculo {

    private String modelo;
    private String placa;
    private boolean precisaManutencao;

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
        this.precisaManutencao = true;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isPrecisaManutencao() {
        return precisaManutencao;
    }

    public void setPrecisaManutencao(boolean precisaManutencao) {
        this.precisaManutencao = precisaManutencao;
    }

    @Override
    public String toString() {

        String status = precisaManutencao
                ? "[Necessita Manutenção]"
                : "[Manutenção em Dia]";

        return status + " " + modelo + " - Placa: " + placa;
    }
}