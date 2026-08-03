package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String, Integer> calculateWord(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        if (text == null || text.trim().isEmpty()) {
            return wordCountMap;
        }

        String[] words = text.toLowerCase().replaceAll("[^a-z0-9çğıöşü]", " ").split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
}