package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(2, "Zeynep", "Kaya"));
        employees.add(new Employee(1, "Ali", "Yılmaz")); // Tekrar eden (Duplicate)
        employees.add(new Employee(3, "Ayşe", "Demir"));
        employees.add(new Employee(4, "Mehmet", "Çelik"));
        employees.add(new Employee(2, "Zeynep", "Kaya")); // Tekrar eden (Duplicate)

        System.out.println("Tekrar Edenler (Duplicates):");
        System.out.println(findDuplicates(employees));

        System.out.println("\nEşsiz Kayıtlar Map'i (Uniques):");
        System.out.println(findUniques(employees));

        System.out.println("\nSadece Bir Kez Geçenler (Remove Duplicates):");
        System.out.println(removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee e : list) {
            if (!seen.add(e) && !duplicates.contains(e)) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee e : list) {
            if (!uniqueMap.containsKey(e.getId())) {
                uniqueMap.put(e.getId(), e);
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();

        for (Employee e : list) {
            frequencyMap.put(e, frequencyMap.getOrDefault(e, 0) + 1);
        }

        LinkedList<Employee> onlySingles = new LinkedList<>();
        for (Employee e : list) {
            if (frequencyMap.get(e) == 1) {
                onlySingles.add(e);
            }
        }
        return onlySingles;
    }
}