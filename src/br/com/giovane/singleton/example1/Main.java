package br.com.giovane.singleton.example1;

public class Main {
    public static void main(String[] args) {

        Window window1 = Window.getInstance1();
        Window window2 = Window.getInstance2();

        window1.abrir();
        window2.abrir();
        Window.INSTANCE.abrir();

    }
}
