package br.com.alura.modelosdecarros;

public class Carro {
    private int ano;
    private double precoAnoUm, precoAnoDois, precoAnoTres;

    void setModelo(String modelo) {
    }

        void setPrecos(double precoAnoUm, double precoAnoDois, double precoAnoTres) {
            this.precoAnoUm = precoAnoUm;
            this.precoAnoDois = precoAnoDois;
            this.precoAnoTres = precoAnoTres;
        }

        double getMedia() {
            return (precoAnoUm + precoAnoDois + precoAnoTres) / 4;
        }

//        public void infCarros() {
//            System.out.println(STR. "Modelo: \{modelo}");
//            System.out.println(STR. "Ano: \{ano}");
//            System.out.println(STR. "Média de valor: \{getMedia()}");
//        }
    }

