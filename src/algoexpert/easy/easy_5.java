package algoexpert.easy;

import java.util.Arrays;

class easy_5 {
    
    // FIXME: tricky!
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int maxFeasibleChange = 0;

        for (int i = 0; i < coins.length; ++i) {
            if (coins[i] > maxFeasibleChange + 1) {
                return maxFeasibleChange + 1;
            }
            maxFeasibleChange += coins[i];
        }

        return maxFeasibleChange + 1;
    }
}

