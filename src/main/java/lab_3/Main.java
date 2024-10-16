package lab_3;

import lab_3.exceptions.FileReadException;
import lab_3.exceptions.InvalidFileFormatException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void printInfo () {
        System.out.println("========================================");
        System.out.println("Info:");
        System.out.println("========================================");
        System.out.println("Input paths to dictionary files on each line.");
        System.out.println("Then, input text you want to translate.");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        if (Arrays.stream(args).toList().contains("--info")) {
            printInfo();
            System.exit(0);
        }

        if (args.length == 0) {
            System.out.println("Please enter your text for translation as first argument to the program.");
            System.exit(1);
        } else if (args.length == 1) {
            System.out.println("Please specify dictionaries paths as arguments to the program after your text.");
            System.exit(1);
        }

        Dictionary translator = new Dictionary();
        for (int dictionary_id = 1; dictionary_id < args.length; dictionary_id++) {
            String dictionaryFilePath = args[dictionary_id];
            // Load file
            try {
                translator.loadTranslationsFromFile(dictionaryFilePath);
            } catch (InvalidFileFormatException | FileReadException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            System.out.println("File " + dictionaryFilePath + " successfully loaded into dictionary!");
        }

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
