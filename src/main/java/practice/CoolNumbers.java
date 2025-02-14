package practice;

import java.util.*;

public class CoolNumbers {
    private static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final int MIN_REGION = 1;
    private static final int MAX_REGION = 199;
    private static final int TOTAL_NUMBERS = 2_000_000;


    public static List<String> generateCoolNumbers1() {

        List<String> numbers = new ArrayList<>(TOTAL_NUMBERS);

        for (int region = MIN_REGION; region <= MAX_REGION; region++) {
            for (char firstLetter : LETTERS) {
                for (char thirdLetter : LETTERS) {
                    for (char secondLetter : LETTERS) {
                        for (int digits = 111; digits <= 999; digits += 111) {
                            if (numbers.size() >= TOTAL_NUMBERS) {
                                return numbers;
                            }
                            numbers.add(String.format("%c%d%c%c%02d", firstLetter, digits, secondLetter, thirdLetter, region));
                        }
                    }
                }
            }
        }

        return numbers;
    }

    public static List<String> generateCoolNumbers() {
        List<String> numbers = new ArrayList<>(TOTAL_NUMBERS);
        StringBuilder sb = new StringBuilder(8);

        int count = 0;
        for (int region = MIN_REGION; region <= MAX_REGION && count < TOTAL_NUMBERS; region++) {
            String regionStr = String.format("%02d", region);
            for (char firstLetter : LETTERS) {
                for (int digits = 111; digits <= 999; digits += 111) {
                    String digitsStr = Integer.toString(digits);
                    for (char secondLetter : LETTERS) {
                        for (char thirdLetter : LETTERS) {
                            sb.setLength(0);
                            sb.append(firstLetter).append(digitsStr).append(secondLetter).append(thirdLetter).append(regionStr);
                            numbers.add(sb.toString());
                            count++;
                            if (count >= TOTAL_NUMBERS) {
                                return numbers;
                            }
                        }
                    }
                }
            }
        }

        return numbers;
    }


    public static List<String> generateCoolNumbers2() {
        List<String> numbersCars = new ArrayList<>(TOTAL_NUMBERS);
        String result;
        for (int i = 0; i < 2_000_000; i++) {
            int numbers = (int) (Math.random() * 9);
            int region = (int) (Math.random() * 199);
            int letter = (int) (Math.random() * LETTERS.length - 1);
            result = LETTERS[letter] + String.valueOf(numbers);
            while (result.length() != 4) {
                //numbers = (int)(Math.random() * 9);
                //Закоментил чтобы генерировались только блатные номера
                result += numbers;
            }
            while (result.length() != 6) {
                letter = (int) (Math.random() * LETTERS.length - 1);
                result += LETTERS[letter];
            }
            if (region < 10) {
                result += "0" + region;
            } else {
                result += region;
            }
            numbersCars.add(result);
        }
        return numbersCars;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        long startTime = System.nanoTime();
        for (String string : list) {
            if (string.equals(number)) {
                long endTime = System.nanoTime();
                System.out.println("BruteForce искали " + number + " Нашли, потребовалось: " + (endTime - startTime) + " нс");
                return true;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("BruteForce искали " + number + " Не нашли, Потребовалось: " + (endTime - startTime) + " нс");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        int result;
        long startTime = System.nanoTime();
        result = Collections.binarySearch(sortedList, number);
        long endTime = System.nanoTime();
        System.out.println("BinSearch искали " + number + " Потребовалось: " + (endTime - startTime) + " нс");

        return result >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        boolean result;
        long startTime = System.nanoTime();
        result = hashSet.contains(number);
        long endTime = System.nanoTime();
        System.out.println("HASHSet искали " + number + " Потребовалось: " + (endTime - startTime) + " нс");
        return result;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        boolean result;
        long startTime = System.nanoTime();
        result = treeSet.contains(number);
        long endTime = System.nanoTime();
        System.out.println("TreeSet искали " + number + " Потребовалось: " + (endTime - startTime) + " нс");
        return result;
    }

}
