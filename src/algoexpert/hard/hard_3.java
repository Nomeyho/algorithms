package algoexpert.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class hard_3 {

    public static void main(String[] args) {
        int[] result = largestRange(new int[] { 8, 4, 2, 10, 3, 6, 7, 9, 1 });
        System.out.println(Arrays.toString(result));
    }

    public static int[] largestRange(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (final int a : array) {
            set.add(a);
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int[] result = new int[] { min, min };
        int[] range = new int[] { min, min };
        for (int i = min + 1; i <= max; i++) {
            // Start new range
            if (!set.contains(i)) {
                // Skip hole
                while(!set.contains(i)) {
                    i++;
                }
                
                range[0] = i;
            }

            if (size(range) > size(result)) {
                result[0] = range[0];
                result[1] = range[1];
            }
            
            range[1] = i;
        }

        if (size(range) > size(result)) {
            result[0] = range[0];
            result[1] = range[1];
        }

        return result;
    }

    private static int size(int[] range) {
        return range[1] - range[0];
    }
}
