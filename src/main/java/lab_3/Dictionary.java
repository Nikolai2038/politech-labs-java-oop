package lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> dictionary = new HashMap<>();

    public Dictionary(String resourcePath) {
        // Get the resource URL
        URL resource = getClass().getResource(resourcePath);

        // Check if resource exists
        if (resource == null) {
            throw new RuntimeException("Dictionary file not found in resources: " + resourcePath);
        }

        // Try reading the resource file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into two words
                String[] parts = line.split("\\|");
                if (parts.length != 2) {
                    throw new RuntimeException("Invalid file format: " + line);
                }
                // Add entry to the dictionary (and ignore case)
                dictionary.put(parts[0].trim().toLowerCase(), parts[1].trim().toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource file: " + e.getMessage());
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
                result.append(dictionary.get(bestMatch));
            } else {
                result.append(words[wordId]);
            }
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
