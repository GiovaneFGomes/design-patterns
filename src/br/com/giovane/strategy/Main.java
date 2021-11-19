package br.com.giovane.strategy;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BigDecimal valor = new BigDecimal("10");
        Compra compra = new Compra(valor);

        compra.processarCompra(new PagamentoCartaoCredito());
        compra.processarCompra(new PagamentoCartaoDebito());

        System.out.println(compra);

    }
}

// -----------------------------------------------------------------------------------

/*
   * Estratégia - Interface (geralmente)
   * Estratégia - Concreta (implementação)
   * Contexto   - quem utiliza a estrategia
 */

// -----------------------------------------------------------------------------------

// Contexto
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

// Estrategia
// Ela quem define o contrato da nossa estrategia
interface PagamentoStrategy {
    void pagar(BigDecimal valor);
}

// -----------------------------------------------------------------------------------

// Estrategia - Concreta 1
class PagamentoCartaoCredito implements PagamentoStrategy {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no crédito R$ " + valor);
    }

}

// -----------------------------------------------------------------------------------

// Estrategia - Concreta 2
class PagamentoCartaoDebito implements PagamentoStrategy {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no débito R$ " + valor);
    }

}

// -----------------------------------------------------------------------------------
