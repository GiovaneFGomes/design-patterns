package br.com.giovane.factory.example2;

public class Main {
    public static void main(String[] args) {

        Moeda real = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(real);

        Moeda dolar = MoedaFactory.criarMoeda(Pais.EUA);
        System.out.println(dolar);

    }
}

// A complexidade de criacao de um objeto fica numa outra classe
