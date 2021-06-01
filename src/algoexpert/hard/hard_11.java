package algoexpert.hard;

import java.util.Arrays;

public class hard_11 {
    
    // O(n^2) time and O(n) space
    // See AlgoExpert for 0(n) and 0(1) solution
    public static int minNumberOfJumps(int[] array) {
        int[] minNumberJumps = new int[array.length];
        Arrays.fill(minNumberJumps, Integer.MAX_VALUE);
        minNumberJumps[0] = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array[i] && (i+j) < array.length; ++j) {
                minNumberJumps[i + j] = Math.min(
                        minNumberJumps[i + j],
                        minNumberJumps[i] + 1
                );
            }
        }

        return minNumberJumps[array.length - 1];
    }
}
