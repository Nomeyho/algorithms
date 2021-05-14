package algoexpert.hard;

import java.util.Arrays;

public class hard_4 {

    public static void main(String[] args) {
        int result = minRewards(new int[]{0, 4, 2, 1, 3});
        System.out.println(result);
    }

    public static int minRewards(int[] scores) {
        int[] sums = new int[scores.length];

        for (int i = 0; i < scores.length; ++i) {
            if (isMin(scores, i)) {
                sums[i] = 1;

                // expand
                int left = i - 1;
                while (left >= 0 && scores[left] > scores[left + 1]) {
                    sums[left] = Math.max(sums[left], sums[left + 1] + 1);
                    left--;
                }

                int right = i + 1;
                while (right < scores.length && scores[right - 1] < scores[right]) {
                    sums[right] = Math.max(sums[right], sums[right - 1] + 1);
                    right++;
                }
            }
        }

        return Arrays.stream(sums).sum();
    }

    private static boolean isMin(int[] array, int i) {
        int left = i < 1 ? Integer.MAX_VALUE : array[i - 1];
        int right = i >= (array.length - 1) ? Integer.MAX_VALUE : array[i + 1];

        return array[i] <= left && array[i] <= right;
    }
}
