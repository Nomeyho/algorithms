package leetcode;

import java.util.Arrays;

public class Solution_1033 {
    
    public static void main(final String[] args) {
        int[] ans = new Solution_1033().numMovesStones(1, 2, 5);
        System.out.println(Arrays.toString(ans));

        ans = new Solution_1033().numMovesStones(4, 3, 2);
        System.out.println(Arrays.toString(ans));

        ans = new Solution_1033().numMovesStones(3, 5, 1);
        System.out.println(Arrays.toString(ans));
    }

    public int[] numMovesStones(int a, int b, int c) {
        if(a < b && b < c) {
            return numMovesStonesHelper(a, b, c);
        } else if (a < c && c < b) {
            return numMovesStonesHelper(a, c, b);
        } else if (b < a && a < c) {
            return numMovesStonesHelper(b, a, c);
        } else if (b < c && c < a) {
            return numMovesStonesHelper(b, c, a);
        } else if (c < a && a < b) {
            return numMovesStonesHelper(c, a, b);
        } else if (c < b && b < a) {
            return numMovesStonesHelper(c, b, a);
        }
        
        throw new IllegalStateException("");
    }

    public int[] numMovesStonesHelper(int a, int b, int c) {
        if (b - a == 2 || c - b == 2) {
            return new int[] { 1, b - a - 1 + c - b - 1 };
        }

        final int[] ans = new int[] { 0, 0 };
        
        if(!areConsecutive(a, b)) {
            ans[0] += 1;
            ans[1] += b - a - 1;
        }

        if(!areConsecutive(b, c)) {
            ans[0] += 1;
            ans[1] += c - b - 1;
        }
        
        return ans;
    }
    
    private static boolean areConsecutive(int a, int b) {
        return b - a == 1;
    }
}
