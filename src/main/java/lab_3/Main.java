package lab_3;

import lab_3.exceptions.FileReadException;
import lab_3.exceptions.InvalidFileFormatException;

import java.util.*;

public class Main {
    // Constant for the dictionary file name in resources
    private static final String DICTIONARY_FILE_PATH_IN_RESOURCES = "/dictionary.txt";

    private final Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        Dictionary translator = null;
        try {
            translator = new Dictionary(DICTIONARY_FILE_PATH_IN_RESOURCES);
        } catch (InvalidFileFormatException | FileReadException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Dictionary successfully loaded!");

        System.out.println("========================================");
        System.out.println("Enter text for translation:");
        System.out.println("========================================");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("========================================");
        System.out.println("Translation:");
        System.out.println("========================================");
        System.out.println(translator.translateText(input));
        System.out.println("========================================");
    }

}
