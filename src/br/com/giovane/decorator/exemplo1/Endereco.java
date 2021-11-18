package br.com.giovane.decorator.exemplo1;

import java.util.Locale;

class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco(
                "Rua Orozimbo Vieira",
                "Sto. Antonio De Padua",
                "Gravataí",
                "UF",
                "94175-140");

        EnderecadorSimples enderecador = new EnderecadorSimples();

        // instancia do decorator (uma classe usando a outra)
        EnderecadorCaixaAlta enderecadorCaixaAlta = new EnderecadorCaixaAlta(enderecador);

        String enderecoFormatado1 = enderecador.preparaEndereco(endereco);
        String enderecoFormatado2 = enderecadorCaixaAlta.preparaEndereco(endereco);

        System.out.println("------FORMATO 1-----");
        System.out.println(enderecoFormatado1);
        System.out.println("------FORMATO 2-----");
        System.out.println(enderecoFormatado2);

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

class EnderecadorSimples {
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

// DECORATOR 1

class EnderecadorCaixaAlta {

    // instancia da Classe EnderecadorSimples
    EnderecadorSimples enderecador;

    public EnderecadorCaixaAlta(EnderecadorSimples enderecador) {
        super();
        this.enderecador = enderecador;
    }

    // metodo proprio (chama a instancia de endereco e transforma para caixa)
    public String preparaEndereco(Endereco endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase(Locale.ROOT);
    }

}

// -----------------------------------------------------------------------------------

