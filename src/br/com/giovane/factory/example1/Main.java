package br.com.giovane.factory.example1;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // virtual constructor
        // static methods

        Calendar.getInstance();
        NumberFormat.getInstance();
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        List<Integer> integers = List.of(1, 2, 3, 4);
        Integer integer = Integer.valueOf("1");

    }
}
