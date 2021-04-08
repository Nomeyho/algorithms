package algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class easy_25 {

    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            characters.put(c, characters.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < string.length(); ++i) {
            if (characters.get(string.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
