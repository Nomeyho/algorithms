package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium_1 {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < array.length - 1; ++i) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];

                if (currentSum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }
    
    /*
    public static void main(final String[] args) {
        List<Integer[]> result = threeNumberSum(new int[]{8, 10, -2, 49, 14}, 57);
        for (final Integer[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();
        Set<String> tripletKeys = new HashSet<>();
        Set<Integer> set = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());

        for (int a : array) {
            for (int b : array) {
                int c = targetSum - a - b;
                if (a != b && c != a && c != b) {
                    Integer[] triplet = new Integer[] { a, b, c };
                    Arrays.sort(triplet);
                    String key = triplet[0] + "_" + triplet[1] + "_" + triplet[2];
                    
                    if (!tripletKeys.contains(key) && set.contains(targetSum - a - b)) {
                        triplets.add(triplet);
                        tripletKeys.add(key);
                    }
                }
            }
        }
        
        triplets.sort((t1, t2) -> {
            if (!t1[0].equals(t2[0])) {
                return t2[0] - t1[0];
            } else if (!t1[1].equals(t2[1])) {
                return t2[1] - t1[1];
            } else {
                return t2[2] - t1[2];
            }
        });
        return triplets;
    }
     */
}
