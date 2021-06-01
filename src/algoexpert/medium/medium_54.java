package algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class medium_54 {
   
    public String[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> characters = new HashMap<>();
        int characterCount = 0;

        for (String word : words) {
            Map<Character, Integer> wordCharacters = new HashMap<>();

            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int f = wordCharacters.getOrDefault(c, 0) + 1;
                wordCharacters.put(c, f);

                if (characters.get(c) == null) {
                    characters.put(c, f);
                    characterCount += f;
                } else if (characters.get(c) < f) {
                    characterCount -= characters.get(c);
                    characterCount += f;
                    characters.put(c, f);
                }
            }
        }

        return toArray(characters, characterCount);
    }

    private static String[] toArray(Map<Character, Integer> map, int size) {
        String[] array = new String[size];
        int i = 0;

        for (final Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                array[i++] = entry.getKey() + "";
            }
        }

        return array;
    }
}
