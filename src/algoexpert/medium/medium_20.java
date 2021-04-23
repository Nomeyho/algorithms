package algoexpert.medium;

public class medium_20 {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        return maxSum(array, 0, array.length - 1);
    }

    // O(n) time and space
    // -> Iterative solution O(1) space
    private static int maxSum(int[] array, int start, int end) {
        if (end - start < 0) {
            return 0;
        }

        if (start == end) {
            return array[start];
        }

        return Math.max(
                array[start] + maxSum(array, start + 2, end),
                array[start + 1] + maxSum(array, start + 3, end)
        );
    }
}