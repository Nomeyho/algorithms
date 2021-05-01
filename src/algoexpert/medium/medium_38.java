package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class medium_38 {

    // See AlgoExpert solution #2 for more optimal approach using swaps
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();

        if (array.isEmpty()) {
            return permutations;
        } else if (array.size() == 1) {
            permutations.add(array);
            return permutations;
        }

        for (int i = 0; i < array.size(); i++) {
            List<Integer> subList = subList(array, i);// assumed to be O(1)
            List<List<Integer>> subListPermutations = getPermutations(subList); // n recursive calls

            for (int j = 0; j < subListPermutations.size(); ++j) { // O(n!) permutations
                subListPermutations.get(j).add(0, array.get(i)); // assumed to be O(1)
                permutations.add(subListPermutations.get(j));
            }
        }

        return permutations;
    }

    // O(n)
    private static List<Integer> subList(List<Integer> array, int exclude) {
        List<Integer> subList = new ArrayList<>(array.size() - 1);

        for (int i = 0; i < array.size(); ++i) {
            if (i != exclude) {
                subList.add(array.get(i));
            }
        }

        return subList;
    }

}
