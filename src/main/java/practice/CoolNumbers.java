package practice;

import java.util.*;

public class CoolNumbers {
    private static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final int MIN_REGION = 1;
    private static final int MAX_REGION = 199;
    private static final int TOTAL_NUMBERS = 2_000_000;


    public static List<String> generateCoolNumbers() {
        /*
            Используйте следующие правила генерации номеров:
            XYZ — различный набор из списка разрешенных букв, N — цифры, R — регион (от 01 до 199);
            XNNNYZR — пример: A111BC197, У777HC66.
            В госномерах автомобилей в РФ используются следующие буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х.
            В коллекции должно быть не менее 2 млн номеров.
        */
        List<String> numbers = new ArrayList<>(TOTAL_NUMBERS);

        for (int region = MIN_REGION; region <= MAX_REGION; region++) {
            for (char firstLetter : LETTERS) {
                for (char thirdLetter : LETTERS) {
                    for (char secondLetter : LETTERS) {
                        for (int digits = 111; digits <= 999; digits += 111) {
                            if (numbers.size() >= TOTAL_NUMBERS) {
                                return numbers;
                            }
                            numbers.add(String.format("%c%d%c%c%02d"
                                    , firstLetter, digits, secondLetter,
                                    thirdLetter, region));
                        }
                    }
                }
            }
        }

        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        long startTime = System.nanoTime();
        for (String string : list){
            if (string.equals(number)){
                long endTime = System.nanoTime();
                System.out.println("BruteForce искали " + number +
                        " Нашли, потребовалось: " + (endTime - startTime)  + " нс");
                return true;
            }        }
        long endTime = System.nanoTime();
        System.out.println("BruteForce искали " + number +
                " Не нашли, Потребовалось: " + (endTime - startTime)  + " нс");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        int result;
        long startTime = System.nanoTime();
        result = Collections.binarySearch(sortedList,number);
        long endTime = System.nanoTime();
        System.out.println("BinSearch искали " + number +
                " Потребовалось: " + (endTime - startTime)  + " нс");

        return result >= 0 ? true: false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        boolean result;
        long startTime = System.nanoTime();
        result = hashSet.contains(number);
        long endTime = System.nanoTime();
        System.out.println("HASHSet искали " + number +
                " Потребовалось: " + (endTime - startTime)  + " нс");
        return result;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        boolean result;
        long startTime = System.nanoTime();
        result = treeSet.contains(number);
        long endTime = System.nanoTime();
        System.out.println("TreeSet искали " + number +
                " Потребовалось: " + (endTime - startTime)  + " нс");
        return result;
    }

}
