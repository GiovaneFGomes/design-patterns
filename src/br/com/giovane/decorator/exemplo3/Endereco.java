package br.com.giovane.decorator.exemplo3;

import java.util.Locale;

class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco(
                "Rua Orozimbo Vieira",
                "Sto. Antonio De Padua",
                "Gravataí",
                "UF",
                "94175-140");

        Enderecador enderecador = new EnderecadorSimples();
        enderecador = new EnderecadorCaixaAlta(enderecador);
        enderecador = new EnderecadorComBorda(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println("------FORMATO 1-----");
        System.out.println(enderecoFormatado);

    }
}

// -----------------------------------------------------------------------------------

class Endereco {
    public String logradouro;
    public String bairro;
    public String cidade;
    public String uf;
    public String cep;

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

// -----------------------------------------------------------------------------------

interface Enderecador {
    String preparaEndereco(Endereco endereco);
}

// -----------------------------------------------------------------------------------

class EnderecadorSimples implements Enderecador {
    public String preparaEndereco(Endereco endereco) {
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logradouro);
        sb.append("\n");
        sb.append(endereco.bairro);
        sb.append("\n");
        sb.append(endereco.cidade);
        sb.append("\n");
        sb.append(endereco.uf);
        sb.append("\n");
        sb.append(endereco.cep);
        return sb.toString();
    }
}

// -----------------------------------------------------------------------------------

// classe abstrata para armazenar a instancia de Enderecador

abstract class EnderecadorDecorator implements Enderecador {

    Enderecador enderecador;

    public EnderecadorDecorator(Enderecador enderecador) {
        super();
        this.enderecador = enderecador;
    }

}

// -----------------------------------------------------------------------------------

// DECORATOR 1

class EnderecadorCaixaAlta extends EnderecadorDecorator {

    public EnderecadorCaixaAlta(Enderecador enderecador) {
        super(enderecador);
    }

    // metodo proprio (chama a instancia de endereco e transforma para caixa)
    public String preparaEndereco(Endereco endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase(Locale.ROOT);
    }

}

// -----------------------------------------------------------------------------------

// DECORATOR 2

class EnderecadorComBorda extends EnderecadorDecorator {

    public EnderecadorComBorda(Enderecador enderecador) {
        super(enderecador);
    }

    public String preparaEndereco(Endereco endereco) {
        String preparaEndereco = enderecador.preparaEndereco(endereco);
        StringBuilder sb = new StringBuilder();
        preparaEndereco.lines().forEach(e -> sb.append("| ").append(e).append("\n"));
        sb.append("--------------------\n");
        return sb.toString();
    }

}

// -----------------------------------------------------------------------------------
