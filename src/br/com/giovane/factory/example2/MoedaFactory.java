package br.com.giovane.factory.example2;

public class MoedaFactory {

    public static Moeda criarMoeda(Pais pais) {
        if(pais.equals(Pais.BRASIL)) {
            return new Real();
        }else if(pais.equals(Pais.EUA)) {
            return new Dolar();
        }
        throw new IllegalArgumentException("Nao existe esse pais");
    }

}
