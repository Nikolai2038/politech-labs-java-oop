package lab_4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void printInfo () {
        System.out.println("========================================");
        System.out.println("Info:");
        System.out.println("========================================");
        System.out.println("...");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // Test averageOfList method
        System.out.println("========================================");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("List: " + numbers);
        System.out.println("Average of list: " + averageOfList(numbers).orElse(0.0));

        // Test transformStrings method
        System.out.println("========================================");
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        System.out.println("List: " + strings);
        System.out.println("Transformed strings: " + transformStrings(strings));

        // Test uniqueSquares method
        System.out.println("========================================");
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println("List: " + duplicateNumbers);
        System.out.println("Unique squares: " + uniqueSquares(duplicateNumbers));

        // Test getLastElement method
        System.out.println("========================================");
        List<String> moreStrings = Arrays.asList("first", "second", "third");
        System.out.println("List: " + moreStrings);
        System.out.println("Last element: " + getLastElement(moreStrings));
        System.out.println("----------------------------------------");
        List<String> moreStringsEmpty = List.of();
        System.out.println("List: " + moreStringsEmpty);
        try {
            System.out.println("Last element: " + getLastElement(moreStringsEmpty));
        } catch (Exception e) {
            System.out.println("Exception raised: " + e.getMessage());
        }

        // Test sumOfEvenNumbers method
        System.out.println("========================================");
        int[] numArray = {1, 2, 3, 4, 5, 6};
        System.out.println("List: " + Arrays.toString(numArray));
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers(numArray));
        System.out.println("----------------------------------------");
        int[] numArrayWithoutEven = {1, 3, 5, 7, 9, 11};
        System.out.println("List: " + Arrays.toString(numArrayWithoutEven));
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers(numArrayWithoutEven));

        // Test convertToMap method
        System.out.println("========================================");
        List<String> stringList = Arrays.asList("apple", "banana", "cherry");
        System.out.println("List: " + stringList);
        System.out.println("Converted map: " + convertToMap(stringList));

        System.out.println("========================================");
    }

    // Method to return the average of a list of integers
    public static OptionalDouble averageOfList(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    // Method to convert all strings in the list to uppercase and add "_new_" prefix
    public static List<String> transformStrings(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // Method to return a list of squares of elements that appear only once in the list
    public static List<Integer> uniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Method to return the last element of a collection or throw an exception if empty
    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    // Method to return the sum of all even numbers in the array or 0 if none exist
    public static int sumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    // Method to convert a list of strings to a Map where the first character is the key and the rest is the value
    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 0)
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1)));
    }
}
