package algoexpert.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class easy_1 {
    public static void main(final String[] args) {
        int[] result = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        final Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());

        for (int a : array) {
            int complement = targetSum - a;
            if (complement != a && set.contains(complement)) {
                return new int[]{a, complement};
            }
        }

        return new int[0];
    }
}