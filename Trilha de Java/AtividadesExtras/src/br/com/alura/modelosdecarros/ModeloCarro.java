package br.com.alura.modelosdecarros;

// Classe Carro
public class ModeloCarro extends Carro {
    private String modelo;
    private double precoAno1, precoAno2, precoAno3;

    public void definirModelo(String modelo) {
        this.modelo = modelo;
    }

    public void exibirInfo() {
        System.out.println(STR. "Modelo: \{modelo}");
        System.out.println(STR. "Preço Ano 1: \{precoAno1} ");
        System.out.println(STR. "Preço Ano 2: \{precoAno2} ");
        System.out.println(STR. "Preço Ano 3: \{precoAno3} ");
    }
}