package algoexpert.easy;

import java.util.Arrays;

public class easy_17 {

    public static int[] findThreeLargestNumbers(int[] array) {
        final int[] max = new int[]{
                array[0],
                array[1],
                array[2]
        };
        Arrays.sort(max);

        for (int i = 3; i < array.length; ++i) {
            int a = array[i];
            if (a >= max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = a;
            } else if (a >= max[1]) {
                max[0] = max[1];
                max[1] = a;
            } else if (a > max[0]) {
                max[0] = a;
            }
        }

        return max;
    }
}
