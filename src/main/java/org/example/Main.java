package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(0, "Elton", "John"));
        employees.add(new Employee(1, "Micheal", "Scott"));
        employees.add(new Employee(2, "Nelson", "Mandela"));
        employees.add(new Employee(3, "Ryan", "Gosling"));
        employees.add(new Employee(4, "Elvis", "Stojko"));
        employees.add(new Employee(5, "Lightning", "McQueen"));
        employees.add(new Employee(5, "Lightning", "McQueen"));

        System.out.println(findUniques(employees));
        System.out.println(findDuplicates(employees));
        System.out.println(removeDuplicates(employees));
        System.out.println(employees);
        System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> list){
        List<Employee> nonDup = new ArrayList<>();
        List<Employee> dup = new ArrayList<>();
        for(Employee emp : list){
            if(nonDup.contains(emp)) dup.add(emp);
            else nonDup.add(emp);
        }
        return dup;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list){
        Map<Integer, Employee> employees= new HashMap<>();
        for(Employee emp : list){
            if(emp!=null) employees.put(emp.getId(), emp);
        }
        return employees;
    }

    public static List<Employee> removeDuplicates(List<Employee> list){
        List<Employee> dummy = new ArrayList<>(list);
        dummy.removeAll(findDuplicates(list));
        return dummy;
    }
}