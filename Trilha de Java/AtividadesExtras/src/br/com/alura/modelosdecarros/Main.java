package br.com.alura.modelosdecarros;

public class Main {
    public static void main(String[] args) {
        ModeloCarro carro = new ModeloCarro();
        carro.definirModelo("Fusca");

        Carro calculo = new Carro();
        calculo.setPrecos(10000, 15000, 20000);

        carro.exibirInfo();
        calculo.getMedia();
    }

}
