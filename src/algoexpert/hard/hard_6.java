package algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class hard_6 {
    public static void main(String[] args) {
        boolean result = sameBsts(
                new ArrayList<>(List.of(10, 15, 8, 12, 94, 81, 5, 2, -1, 101, 45, 12, 8, -1, 8, 2, -34)),
                new ArrayList<>(List.of(10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 8, 12, 45, 100))
        );
        System.out.println(result);
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.isEmpty()) {
            return true;
        }

        return sameBsts(arrayOne, arrayTwo, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
    }

    private static boolean sameBsts(List<Integer> arrayOne,
                                    List<Integer> arrayTwo,
                                    int minValue,
                                    int maxValue,
                                    int i,
                                    int j) {
        if (i == -1 && j == -1) {
            return true;
        } else if (i == -1 || j == -1) {
            return false;
        }

        // Root must be identical
        if (arrayOne.get(i) != arrayTwo.get(j)) {
            return false;
        }

        int rightIndexOne = successorIndex(arrayOne, i, maxValue);
        int rightIndexTwo = successorIndex(arrayTwo, j, maxValue);

        int leftIndexOne = predecessorIndex(arrayOne, i, minValue);
        int leftIndexTwo = predecessorIndex(arrayTwo, j, minValue);

        return sameBsts(arrayOne, arrayTwo, arrayOne.get(i), maxValue, rightIndexOne, rightIndexTwo)
                && sameBsts(arrayOne, arrayTwo, minValue, arrayOne.get(i), leftIndexOne, leftIndexTwo);
    }

    // Find the index of the successor of index 'i' in 'array'
    private static int successorIndex(List<Integer> array, int i, int maxValue) {
        int value = array.get(i);
        i++;

        while (i < array.size()) {
            if (array.get(i) >= value && array.get(i) < maxValue) {
                return i;
            }
            i++;
        }

        return -1;
    }

    // Find the index of the predecessor of index 'i' in 'array', 
    private static int predecessorIndex(List<Integer> array, int i, int minValue) {
        int value = array.get(i);
        i++;

        while (i < array.size()) {
            if (array.get(i) < value && array.get(i) >= minValue) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
