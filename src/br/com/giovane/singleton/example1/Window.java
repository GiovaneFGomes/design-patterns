package br.com.giovane.singleton.example1;

public final class Window {

    public static final Window INSTANCE = new Window();

    private static Window singletonInstance;

    // construtor privado para nao ser instanciado em subclasses
    private Window() {
    }

    // método responsável pelo controle de uma única instância
    // é static para que possa chama-lo sem instanciar a classe
    public static Window getInstance1() {
        return INSTANCE;
    }

    // segunda maneira de fazer, verificando se a singletonInstance é nulo
    public static Window getInstance2() {
        if(singletonInstance == null) {
            singletonInstance = new Window();
        }
        return singletonInstance;
    }

    public void abrir() {
        System.out.println("Opened the window...");
    }

    public  void fechar() {
        System.out.println("Closed the window...");
    }

}
