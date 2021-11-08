package br.com.giovane.singleton;

public final class Janela {

    private static final Janela INSTANCE = new Janela();

    private static Janela singletonInstance;

    // construtor privado para nao ser mais instanciado em subclasses
    private Janela() {
    }

    // Método responsável pelo controle de uma única instância
    // É static para que possa chama-lo sem instanciar a classe
    public static Janela getInstance() {
        return INSTANCE;
    }

    // Segunda maneira de fazer, verificando se a singletonInstance é nulo
    public static Janela getInstance2() {
        if(singletonInstance == null) {
            singletonInstance = new Janela();
        }
        return singletonInstance;
    }

    public void abrir() {
        System.out.println("Abriu a janela...");
    }

    public  void fechar() {
        System.out.println("Fechou a janela...");
    }

}
