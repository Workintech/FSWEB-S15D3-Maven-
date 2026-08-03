package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeesList = new LinkedList<>();

        employeesList.add(new Employee(1,"Kenan", "Turgay"));
        employeesList.add(new Employee(2,"Ahmet", "Turgay"));
        employeesList.add(new Employee(1,"Kenan", "Turgay"));
        employeesList.add(new Employee(1,"Kenan", "Turgay"));

        employeesList.add(new Employee(4,"Mehmet Ali", "Turgay"));
        employeesList.add(new Employee(5,"Zeynep", "Turgay"));
        employeesList.add(new Employee(5,"Zeynep", "Turgay"));

        employeesList.add(new Employee(6,"Ayfer", "Turgay"));


        System.out.println("Tekrar eden employees: " + findDuplicates(employeesList));

        System.out.println("***********************************************");

        System.out.println("Benzer içermeyen liste: " + findUniques(employeesList));

        System.out.println("**********************************************");

        System.out.println("Sadece Tek geçen kayıtlar: " + removeDuplicates(employeesList));


    }

    public static List<Employee> findDuplicates(List<Employee> employeesList) {

        Set<Employee> uniqueList = new HashSet<>();
        List<Employee> duplicatesEmployee = new LinkedList<>();

        for(Employee employee : employeesList){
            if(!uniqueList.add(employee)){
                duplicatesEmployee.add(employee);// In here, it just adds the repeating employee
            }
        }

        return duplicatesEmployee;
    }

    public static Map<Integer, String> findUniques(List<Employee> employeesList){

        Set<Employee> uniqueList = new HashSet<>();

        Map<Integer, String> donRepeatEmployee = new HashMap<>();


        for (Employee employee : employeesList) {

            if (uniqueList.add(employee)) {
                donRepeatEmployee.put(employee.getId(), employee.getFirstname() + " " + employee.getLastname());
            }
        }

        return donRepeatEmployee;

    }

    public static List<Employee> removeDuplicates(List<Employee> employeesList){

        List  removeDuplicates = new LinkedList();
        Set uniqueList = new HashSet<>();


        for(Employee employee : employeesList){
            if(uniqueList.add(employee)){
                removeDuplicates.add(employee);
            }else{

                removeDuplicates.remove(employee);
            }
        }

        return removeDuplicates;
    }


}
