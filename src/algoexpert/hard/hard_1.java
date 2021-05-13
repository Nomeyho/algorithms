package algoexpert.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hard_1 {
    
    // best O(n^2) - worst O(n^3)
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> pairs = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();

        // O(n)
        for (int i = 0; i < array.length; i++) {
            // loop 1: find complementary sum
            // O(n)
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                int diff = targetSum - sum;

                if (pairs.containsKey(diff)) {
                    // best O(1) - worst O(n)
                    for (final Integer[] pair : pairs.get(diff)) {
                        result.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }

            // loop 2: add the new pair sum (avoid duplicates)
            // O(n)
            for (int j = 0; j < i; j++) {
                int sum = array[i] + array[j];
                List<Integer[]> p = pairs.getOrDefault(sum, new ArrayList<>());
                p.add(new Integer[]{array[i], array[j]});
                pairs.put(sum, p);
            }
        }

        return result;
    }
}
