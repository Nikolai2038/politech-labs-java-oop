package lab_3;

import lab_3.exceptions.FileReadException;
import lab_3.exceptions.InvalidFileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// Class to translate text with specified dictionary
public class Dictionary {
    // Dictionary itself, containing words/phrases to translations
    private final Map<String, String> dictionary = new HashMap<>();

    public void loadTranslationsFromFile(String filePath) throws InvalidFileFormatException, FileReadException {
        // Try reading the file from the provided file path
        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into two words
                String[] parts = line.split("\\|");
                if (parts.length != 2) {
                    throw new InvalidFileFormatException("Invalid file format: " + line);
                }
                // Add entry to the dictionary (and ignore case)
                dictionary.put(parts[0].trim().toLowerCase(), parts[1].trim().toLowerCase());
            }
        } catch (IOException e) {
            throw new FileReadException("Error reading file: " + e.getMessage());
        }
    }

    // Translate input text based on dictionary
    public String translateText(String input) {
        String[] words = input.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int wordId = 0; wordId < words.length; wordId++) {
            // Ignore case
            String word = words[wordId].toLowerCase();

            String bestMatch = findBestMatch(word);
            if (bestMatch != null) {
                // If match found - add it to the result
                result.append(dictionary.get(bestMatch));
            } else {
                // If no match found - just add the word as it was
                result.append(words[wordId]);
            }

            // Add space between words
            if (wordId < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // Find the best matching translation in the dictionary
    private String findBestMatch(String input) {
        // Sort and use match with max length
        return dictionary.keySet().stream()
                .filter(input::startsWith)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}
