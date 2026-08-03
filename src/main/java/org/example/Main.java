package org.example;

import org.example.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Employee> findDuplicates(List<Employee> employees) {
        if (employees == null) return new ArrayList<>();
        Map<Integer, Long> counts = employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));

        // return one Employee per duplicated id (use first occurrence's names if available)
        Map<Integer, Employee> firstById = employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Employee::getId, e -> e, (existing, replacement) -> existing));

        return counts.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> firstById.get(e.getKey()))
                .collect(Collectors.toList());
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        if (employees == null) return new HashMap<>();
        return employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Employee::getId, e -> e, (existing, replacement) -> existing));
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        if (employees == null) return new ArrayList<>();
        Map<Integer, Long> counts = employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Employee::getId, Collectors.counting()));


        return employees.stream()
                .filter(Objects::nonNull)
                .filter(e -> counts.getOrDefault(e.getId(), 0L) == 1L)
                .collect(Collectors.toList());
    }
}