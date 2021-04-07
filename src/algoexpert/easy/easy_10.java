package algoexpert.easy;

import java.util.Arrays;

class easy_10 {

    public static void main(final String[] args) {
        int result = new easy_10().minimumWaitingTime(new int[]{ 25, 30, 2, 1 });
        System.out.println(result);
    }

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int minimumWaitingTime = 0;
        int currentWaitingTime = 0;

        for (int i = 0; i < queries.length - 1; ++i) {
            minimumWaitingTime += currentWaitingTime + queries[i];
            currentWaitingTime += queries[i];
        }

        return minimumWaitingTime;
    }
}

