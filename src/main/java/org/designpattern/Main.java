package org.designpattern;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Map<Character, Integer> map = getNonRepeatedCharIndices("abcdcaf");
        System.out.println("Output of the Non Repeated Char Indices : " + map);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        List<Object> doubleNumbers = doubleTheValue(numbers);
        System.out.println("Output of the double the array list value : " + doubleNumbers);
    }

    public static Map<Character, Integer> getNonRepeatedCharIndices(String text) {
        Map<Character, Integer> charIndices = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!charIndices.containsKey(ch)) {
                charIndices.put(ch, i);
            } else {
                charIndices.put(ch, -1);
            }
        }
        return charIndices.entrySet().stream().filter(entry -> entry.getValue() != -1).collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);
    }

    public static List<Object> doubleTheValue(ArrayList<Integer> input) {
        Integer[] result = input.stream().map(i -> i * 2).toArray(Integer[]::new);
        return Arrays.stream(result).collect(Collectors.toList());
    }
}