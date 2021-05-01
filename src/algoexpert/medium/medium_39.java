package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class medium_39 {

    public static void main(String[] args) {
        List<List<Integer>> result = powerset(List.of(1, 2, 3));
        
        for (final List<Integer> set : result) {
            System.out.println(set);
        }
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        return powerset(0, array);
    }

    // 1 recursive calls -> depth n
    // 2^n possibles sets, each of size at most n
    // -> O(n * 2^n) as upper bound for both space and time complexity
    private static List<List<Integer>> powerset(int i, List<Integer> array) {
        if (i >= array.size()) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        int value = array.get(i);
        List<List<Integer>> powersets = powerset(i + 1, array);

        for (int j = 0, J = powersets.size(); j < J; j++) {
            List<Integer> copy = new ArrayList<>(powersets.get(j));
            copy.add(value);
            powersets.add(copy);
        }

        return powersets;
    }
}
