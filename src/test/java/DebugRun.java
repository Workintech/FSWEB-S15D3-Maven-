package org.example;

import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DebugRun {
    @Test
    public void debugCalculatedWord() {
        Map<String,Integer> m = WordCounter.calculatedWord();
        System.out.println("wordCount size=" + m.size());
        m.entrySet().stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}