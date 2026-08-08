package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> empleyees = new LinkedList<>();

        Employee employee = new Employee(1,"Kaan","Yazar");
        Employee employee1 = new Employee(1,"Erdal","Yazar");
        Employee employee4 = new Employee(1,"Erdal2","Kuş");
        Employee employee2 = new Employee(2,"Metehan","Kural");
        Employee employee5 = new Employee(2,"İrem","Kural");
        Employee employee3 = new Employee(3,"Hami","Satilmis");

        empleyees.add(employee);
        empleyees.add(employee1);
        empleyees.add(employee2);
        empleyees.add(employee3);
        empleyees.add(employee4);
        empleyees.add(employee5);

        System.out.println(findUniques(empleyees));





    }
    public static List<Employee> findDuplicates(List<Employee> emps) {
        List<Employee> duplicates = new LinkedList<>();

        for (int i = 0; i < emps.size(); i++) {
            // Check if the current employee is null
            if (emps.get(i) == null) {
                continue; // Skip null entries
            }

            for (int j = i + 1; j < emps.size(); j++) {
                // Check if the next employee is null
                if (emps.get(j) == null) {
                    continue; // Skip null entries
                }

                // Compare employee IDs after confirming both are not null
                if (emps.get(i).getId().equals(emps.get(j).getId())) {
                    // Add the first employee if it's not already in the duplicates list
                    if (!duplicates.contains(emps.get(i))) {
                        duplicates.add(emps.get(i));
                    }
                    // Add the second employee if it's not already in the duplicates list
                    if (!duplicates.contains(emps.get(j))) {
                        duplicates.add(emps.get(j));
                    }
                }
            }
        }
        return duplicates;
    }


    public static Map<Integer, Employee> findUniques(List<Employee> emps) {
        Map<Integer, Employee> countMap = new HashMap<>();

        for (Employee emp : emps) {
            if (emp != null){

            Integer id = emp.getId();
            countMap.put(id, emp);
            }
        }

        return countMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> emps) {
        Map<Employee, Integer> countMap = new HashMap<>();
        List<Employee> unique = new LinkedList<>();

        for (Employee emp : emps) {
            if (emp != null) {
                countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
            }
        }

        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                unique.add(entry.getKey());
            }
        }

        return unique;
    }

}