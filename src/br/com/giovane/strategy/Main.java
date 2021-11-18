package br.com.giovane.strategy;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

    }
}

// -----------------------------------------------------------------------------------

// contexto
class Compra {

    BigDecimal valor;

    public Compra(BigDecimal valor) {
        this.valor = valor;
    }

    void processarCompra(PagamentoStrategy strategy) {
        strategy.pagar(valor);
    }

}

// -----------------------------------------------------------------------------------

// Ela quem define o contrato da nossa estrategia
interface PagamentoStrategy {
    void pagar(BigDecimal valor);
}

// -----------------------------------------------------------------------------------

// Estrategia - concreta
class PagamentoCartaoCredito implements PagamentoStrategy {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no crédito " + valor);
    }

}

// -----------------------------------------------------------------------------------

// Estrategia - concreta
class PagamentoCartaoDebito implements PagamentoStrategy {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no débito " + valor);
    }

}

// -----------------------------------------------------------------------------------
