package lab_3;

import lab_3.exceptions.FileReadException;
import lab_3.exceptions.InvalidFileFormatException;

import java.util.Scanner;

public class Main {
    public static void printInfo () {
        System.out.println("========================================");
        System.out.println("Info:");
        System.out.println("========================================");
        System.out.println("...");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter your text for translation as first argument to the program.");
            System.exit(1);
        } else if (args.length == 1) {
            System.out.println("Please specify dictionaries paths as arguments to the program after your text.");
            System.exit(1);
        }

        Dictionary translator = new Dictionary();
        for (int dictionary_id = 0; dictionary_id < args.length - 1; dictionary_id++) {
            String dictionaryFilePath = args[dictionary_id];
            // Load file
            try {
                translator.loadTranslationsFromFile(dictionaryFilePath);
            } catch (InvalidFileFormatException | FileReadException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
            System.out.println("File " + dictionaryFilePath + " successfully loaded!");
        }
        System.out.println("Dictionary successfully loaded!");

        // Get input from user
        System.out.println("========================================");
        System.out.println("Enter text for translation:");
        System.out.println("========================================");

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
