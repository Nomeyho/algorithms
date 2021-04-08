package algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class easy_24 {

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> frequencies = computeFrenquencies(characters);
        
        
        for (int i = 0; i < document.length(); ++i) {
            char c = document.charAt(i);
            int frequency = frequencies.getOrDefault(c, 0);

            if (frequency <= 0) {
                return false;
            }
            
            frequencies.put(c, frequency - 1);
        }

        return true;
    }

    // O(n) time - O(n) space
    private static Map<Character, Integer> computeFrenquencies(String characters) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < characters.length(); ++i) {
            char c = characters.charAt(i);
            int frequency = frequencies.getOrDefault(c, 0);
            frequencies.put(c, frequency + 1);
        }

        return frequencies;
    }
}
