package practice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import static practice.CoolNumbers.*;

public class Main {

    public static void main(String[] args) {

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        System.out.println("FOR+StringBuilder");
        long startTime = System.nanoTime();
        ArrayList<String> coolNumbers = new ArrayList<>(generateCoolNumbers());
        long endTime = System.nanoTime();
        HashSet<String> coolNumbersSet = new HashSet<>(coolNumbers);

        System.out.println("Сгенерировано " + coolNumbers.size() + " блатных номеров.");
        System.out.println("Уникальных " + coolNumbersSet.size());
        System.out.println("Потребовалось: " + numberFormat.format(endTime - startTime) + " нс");

        System.out.println("FOR+String.Format");
        startTime = System.nanoTime();
        coolNumbers = new ArrayList<>(generateCoolNumbers1());
        endTime = System.nanoTime();
        coolNumbersSet.clear();
        coolNumbersSet.addAll(coolNumbers);

        System.out.println("Сгенерировано " + coolNumbers.size() + " блатных номеров.");
        System.out.println("Уникальных " + coolNumbersSet.size());
        System.out.println("Потребовалось: " + numberFormat.format(endTime - startTime) + " нс");

        System.out.println("Math.Random");
        startTime = System.nanoTime();
        coolNumbers = new ArrayList<>(generateCoolNumbers2());
        endTime = System.nanoTime();
        coolNumbersSet.clear();
        coolNumbersSet.addAll(coolNumbers);

        System.out.println("Сгенерировано " + coolNumbers.size() + " блатных номеров.");
        System.out.println("Уникальных " + coolNumbersSet.size());
        System.out.println("Потребовалось: " + numberFormat.format(endTime - startTime) + " нс");
    }

}
