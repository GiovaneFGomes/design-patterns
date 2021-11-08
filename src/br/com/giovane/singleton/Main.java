package br.com.giovane.singleton;

public class Main {
    public static void main(String[] args) {
        Janela janela = Janela.getInstance();
        Janela janela2 = Janela.getInstance2();

        janela.abrir();
        janela.fechar();

        janela2.abrir();
        janela2.fechar();
    }
}
