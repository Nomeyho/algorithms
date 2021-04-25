package algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class medium_24 {

    // Iterative version available on AlgoExpert
    public int numberOfWaysToTraverseGraph(int width, int height) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return numberOfWaysToTraverseGraph(width, height, memo);
    }

    private int numberOfWaysToTraverseGraph(int width, int height, Map<String, Integer> memo) {
        if (width == 1 || height == 1) {
            return 1;
        }

        String key = width + "-" + height;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int numberOfWays = numberOfWaysToTraverseGraph(width - 1, height)
                + numberOfWaysToTraverseGraph(width, height - 1);
        memo.put(key, numberOfWays);
        return numberOfWays;
    }
}