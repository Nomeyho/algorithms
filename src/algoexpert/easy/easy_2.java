package algoexpert.easy;

import java.util.List;

class easy_2 {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int j = 0;

        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i) == sequence.get(j)) {
                j++;
            }

            if (sequence.size() == j) {
                return true;
            }
        }

        return false;
    }
}

