package fer.oop.zzv11.zad7;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Word count:");
        List<String> words = List.of("A", "B", "C", "D", "E", "E");
        wordCount(words, "A", "E").forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Char count:");
        charactersFrequency("testing AAA").forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static Map<String, Integer> wordCount(List<String> words, String... lookingFor) {
        Map<String, Integer> wordMap = new TreeMap<>();
        for (String word : lookingFor) {
            wordMap.put(word, 0);
        }
        words.forEach((word) -> wordMap.computeIfPresent(word, (key, value) -> value + 1));
        return wordMap;
    }

    public static Map<Character, Integer> charactersFrequency(String str) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {
            charMap.computeIfPresent(c, (k, v) -> v + 1);
            charMap.putIfAbsent(c, 1);
        }
        return charMap;
    }
}
