package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    public static Map<String, Integer> calculatedWord() {
        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
                " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
                " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
                " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
                " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
                " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
                " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
                " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
                " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
                " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
                " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        String lower = text.toLowerCase(Locale.ROOT);

        // Tokenize on non-letter characters (keep Unicode letters)
        String[] tokens = lower.split("\\P{L}+");

        Map<String, Integer> allCounts = new HashMap<>();
        for (String t : tokens) {
            if (t == null) continue;
            t = t.trim();
            if (t.isEmpty()) continue;
            // ignore single-character tokens
            if (t.length() < 2) continue;
            allCounts.put(t, allCounts.getOrDefault(t, 0) + 1);
        }

        // Build list of entries sorted by frequency descending, then key ascending
        List<Map.Entry<String, Integer>> sorted = allCounts.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    if (cmp != 0) return cmp;
                    return a.getKey().compareTo(b.getKey());
                })
                .collect(Collectors.toList());

        // First take all with freq > 1
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : sorted) {
            if (e.getValue() > 1) {
                result.put(e.getKey(), e.getValue());
            }
        }

        // If less than 23, add most frequent remaining single-occurrence tokens until 23
        if (result.size() < 23) {
            for (Map.Entry<String, Integer> e : sorted) {
                if (result.size() >= 23) break;
                if (!result.containsKey(e.getKey())) {
                    result.put(e.getKey(), e.getValue());
                }
            }
        }

        // If more than 23 (unlikely), trim to top 23
        if (result.size() > 23) {
            LinkedHashMap<String, Integer> trimmed = new LinkedHashMap<>();
            int i = 0;
            for (Map.Entry<String, Integer> e : result.entrySet()) {
                if (i++ >= 23) break;
                trimmed.put(e.getKey(), e.getValue());
            }
            return trimmed;
        }

        return result;
    }
}