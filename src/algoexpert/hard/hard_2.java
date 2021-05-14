package algoexpert.hard;

import java.util.*;

public class hard_2 {

    public static void main(String[] args) {
        int[] result = subarraySort(new int[] { 2, 1 });
        System.out.println(Arrays.toString(result));
    }
    
    // More elegant implementation on AlgoExpert
    // O(n) time complexity and O(1) space complexity
    public static int[] subarraySort(int[] array) {
        int[] result = new int[] { -1, -1 };

        // Start index
        int firstMisplacedIndex = -1;
        int minMisplaced = Integer.MAX_VALUE;;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                firstMisplacedIndex = i;
                break;
            }
        }
        
        if (firstMisplacedIndex != - 1) {
            for (int i = firstMisplacedIndex; i < array.length; i++) {
                if (array[i] <= minMisplaced) {
                    minMisplaced = array[i];
                }
            }

            for (int i = 0; i <= firstMisplacedIndex; i++) {
                if (array[i] > minMisplaced) {
                    result[0] = i;
                    break;
                }
            }
        }

        // End index
        int lastMisplacedIndex = -1;
        int maxMisplaced = Integer.MIN_VALUE;

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                lastMisplacedIndex = i;
                break;
            }
        }
        
        if (lastMisplacedIndex != -1) {
            for (int i = lastMisplacedIndex; i >= 0; i--) {
                if (array[i] >= maxMisplaced) {
                    maxMisplaced = array[i];
                }
            }

            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] <= maxMisplaced) {
                    result[1] = i;
                    break;
                }
            }
        }

        return result;
    }
}
