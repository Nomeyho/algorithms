package algoexpert.medium;

import java.util.*;

public class medium_49 {

    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String key = sort(word);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(word);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }

    private static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
