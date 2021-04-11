package algoexpert.medium;

import java.util.Arrays;
import java.util.List;

public class medium_3 {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;

        while (i < j) {
            if (array.get(i) == toMove) {
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }

        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j)); // O(1) for ArrayList
        array.set(j, tmp);
    }

}
