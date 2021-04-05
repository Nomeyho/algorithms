package leetcode;

import java.util.*;

public class Solution_7 {

    public static void main(final String[] args) {
        final int result = new Solution_7().reverse(-123);
        System.out.println(result);
    }

    public int reverse(int x) {
        final Deque<Integer> stack = new ArrayDeque<>();
        
        // reversal
        int power = 1;
        while (x != 0) {
            final int reminder = x % 10;
            stack.add(reminder);
            
            x = x - reminder;
            x = x / 10;
            power++;
        }

        // result
        int result = 0;
        power = power - 2;
        while (!stack.isEmpty()) {
            result += stack.pop() * Math.pow(10, power);
            power--;
        }
        
        return result;
    }

}
