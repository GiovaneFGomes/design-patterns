package br.com.giovane.factory.exemplo1;

public class MoedaFactoryTest {
    public static void main(String[] args) {
        Moeda moeda1 = MoedaFactory.criarMoeda(Pais.BRASIL);
        System.out.println(moeda1);

        Moeda moeda2 = MoedaFactory.criarMoeda(Pais.EUA);
        System.out.println(moeda2);
    }
}

// A complexidade de criacao de um objeto fica numa outra classe
