package algoexpert.medium;

import java.util.Arrays;

public class medium_2 {
    
    // Simplier solution on AlgoExpert, although same asymptotic complexity
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0;
        int j = 0;
        int min = diff(arrayOne[0], arrayTwo[0]); // non-empty inputs
        int[] result = new int[]{arrayOne[0], arrayTwo[0]};

        while (true) {
            int diff = diff(arrayOne[i], arrayTwo[j]);

            if (diff < min) {
                min = diff;
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
            }

            if (i == arrayOne.length - 1 && j == arrayTwo.length - 1) {
                break; // end
            } else if (i == arrayOne.length - 1) {
                j++;
            } else if (j == arrayTwo.length - 1) {
                i++;
            } else {
                int diffOne = diff(arrayOne[i + 1], arrayTwo[j]);
                int diffTwo = diff(arrayOne[i], arrayTwo[j + 1]);
                if (diffOne <= diff) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    private static int diff(int a, int b) {
        return Math.abs(a - b);
    }

}
