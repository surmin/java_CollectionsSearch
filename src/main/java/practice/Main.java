package practice;

import java.util.ArrayList;

import static practice.CoolNumbers.generateCoolNumbers;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализировать полученные данные
     */

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        ArrayList<String> coolNumbers = new ArrayList<>(generateCoolNumbers());
        long endTime = System.nanoTime();

        System.out.println("Сгенерировано " + coolNumbers.size() + " блатных номеров.");
        System.out.println("Потребовалось: " + (endTime - startTime)  + " нс");


    }

}
