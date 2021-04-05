package leetcode;

import java.util.Arrays;

public class Solution_942 {
    
    public static void main(final String[] args) {
        final int[] ans = new Solution_942().diStringMatch("DDI");
        System.out.println(Arrays.toString(ans));
    }

    public int[] diStringMatch(final String S) {
        final int[] ans = new int[S.length() + 1];

        int max = S.length(), min = 0, pos = 0;
        while (pos < S.length()) {
            if (S.charAt(pos) == 'D') {
                ans[pos++] = max--;
            } else {
                ans[pos++] = min++;
            }
        }

        ans[pos] = min;
        return ans;
    }

}
