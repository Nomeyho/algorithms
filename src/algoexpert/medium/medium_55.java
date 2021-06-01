package algoexpert.medium;

import java.util.Arrays;
import java.util.Stack;

public class medium_55 {

    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = array.length * 2; i > 0; i--) {
            int index = i % array.length;
            int arrayValue = array[index];

            while (!stack.isEmpty()) {
                int stackValue = stack.pop();

                if (arrayValue < stackValue) {
                    // Next greater element found
                    result[index] = stackValue;
                    stack.push(stackValue);
                    break;
                }
            }

            stack.push(arrayValue);
        }

        return result;
    }
}
