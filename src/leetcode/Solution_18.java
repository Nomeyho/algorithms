package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_18 {

    public static void main(final String[] args) {
        final int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        final List<List<Integer>> result = new Solution_18().fourSum(nums, 0);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final Set<Quad> solutions = new HashSet<>();
        final Map<Integer, Set<Pair>> sums = new HashMap<>();

        // Build map
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j) {
                    final int a = nums[i];
                    final int b = nums[j];
                    final int sum = a + b;
                    final Pair pair = new Pair(a, b);

                    if (sums.containsKey(sum)) {
                        sums.get(sum).add(pair);
                    } else {
                        final Set<Pair> pairs = new HashSet<>();
                        pairs.add(pair);
                        sums.put(sum, pairs);
                    }
                }
            }
        }

        // Process
        for (final Integer sum : sums.keySet()) {
            final int key = target - sum; // target - a - b

            if (sums.containsKey(key)) {
                // we have a dual sum

                for (final Pair pair1 : sums.get(sum)) {
                    for (final Pair pair2 : sums.get(key)) {
                        if (pair1 != pair2) {
                            final Quad solution = new Quad(pair1.a, pair1.b, pair2.a, pair2.b);
                            solutions.add(solution);
                        }
                    }
                }
            }
        }

        // Format results
        return solutions.stream()
                .map(Quad::asList)
                .distinct()
                .collect(Collectors.toList());
    }

    private static class Pair {
        final int a;
        final int b;

        private Pair(final int a, final int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    private static class Quad {
        final List<Integer> values = new ArrayList<>();

        private Quad(final int a, final int b, final int c, final int d) {
            values.add(a);
            values.add(b);
            values.add(c);
            values.add(d);
            Collections.sort(values);
        }

        List<Integer> asList() {
            return values;
        }
    }


}
