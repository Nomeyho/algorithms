package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_169 {

    public static void main(final String[] args) {
        final int[] nums = new int[]{3, 2, 3};
        final int ans = new Solution_169().majorityElement(nums);
        System.out.println(ans);
    }

    // Optimal: https://hengwang.medium.com/algorithm-boyer-moore-majority-voting-528e2d23fb25 
    
    public int majorityElement(final int[] nums) {
        final Map<Integer, Integer> occurrences = new HashMap<>();
        final int threshold = nums.length / 2;

        for (final int num : nums) {
            final int count = occurrences.getOrDefault(num, 0) + 1;

            if (count > threshold) {
                return num;
            }

            occurrences.put(num, count);
        }

        throw new IllegalArgumentException("No solution");
    }

}
