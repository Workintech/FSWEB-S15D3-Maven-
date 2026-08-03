package org.example;

import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new LinkedList<>();
        employees.add(new Employee(1, "dogancan", "kinik"));
        employees.add(new Employee(1, "dogancan", "kinik"));
        employees.add(new Employee(2, "seyyit", "kose"));
        employees.add(new Employee(3, "mehmet", "ali"));
        employees.add(new Employee(4, "mehmet", "ali"));
        employees.add(null);
    }

    @Test
    @DisplayName("Employee findDuplicates metodu doğru çalışıyor mu?")
    public void testFindDuplicates() {
        List<Employee> duplicates = Main.findDuplicates(employees);
        assertEquals(duplicates.size(), 1);
        assertEquals(duplicates.get(0).getId(), 1);
    }

    @Test
    @DisplayName("Employee findUniques metodu doğru çalışıyor mu?")
    public void testFindUniques() {
        Map<Integer, Employee> uniques = Main.findUniques(employees);
        assertEquals(uniques.size(), 4);
    }

    @Test
    @DisplayName("Employee removeDuplicates metodu doğru çalışıyor mu?")
    public void testRemoveDuplicates() {
        List<Employee> results = Main.removeDuplicates(employees);
        assertEquals(results.size(), 3);
    }

    @Test
    @DisplayName("WordCounter calculatedWord metodu doğru çalışıyor mu?")
    public void testCalculatedWord() {
        Map<String, Integer> wordCount = WordCounter.calculatedWord();
        assertThat(wordCount, instanceOf(Map.class));
        assertThat(wordCount.size(), is(23));
    }
}