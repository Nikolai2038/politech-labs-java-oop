package lab_3;

import lab_3.exceptions.FileReadException;
import lab_3.exceptions.InvalidFileFormatException;

import java.util.Scanner;

public class Main {
    // Constant for the dictionary file name in resources
    private static final String DICTIONARY_FILE_PATH_IN_RESOURCES = "/dictionary.txt";

    public static void printInfo () {
        System.out.println("========================================");
        System.out.println("Info:");
        System.out.println("========================================");
        System.out.println("...");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // Load dictionary
        Dictionary translator = null;
        try {
            translator = new Dictionary(DICTIONARY_FILE_PATH_IN_RESOURCES);
        } catch (InvalidFileFormatException | FileReadException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Dictionary successfully loaded!");

        // Get input from user
        System.out.println("========================================");
        System.out.println("Enter text for translation:");
        System.out.println("========================================");

        if (args.length == 0) {
            System.out.println("Please enter your text for translation as first argument to the program.");
            System.exit(1);
        }

        String input = args[0];
        System.out.println(input);

        // Translate and print it
        System.out.println("========================================");
        System.out.println("Translation:");
        System.out.println("========================================");
        System.out.println(translator.translateText(input));
        System.out.println("========================================");
    }

}
