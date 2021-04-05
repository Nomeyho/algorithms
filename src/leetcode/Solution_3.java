package leetcode;

public class Solution_3 {

    public static void main(final String[] args) {
        final int result = new Solution_3().lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    // Optimize solution: https://youtu.be/WKTgajDkVcA
    public int lengthOfLongestSubstring(String s) {
        int longestSubstrLen = 0;

        for (int i = 0; i < s.length(); ++i) {
            boolean[] chars = new boolean[256];
            int currentSubstrLen = 0;

            for (int j = i; j < s.length(); ++j) {
                char c = s.charAt(j);

                if (chars[c]) {
                    break;
                } else {
                    chars[c] = true;
                    currentSubstrLen++;
                }
            }

            if (currentSubstrLen > longestSubstrLen) {
                longestSubstrLen = currentSubstrLen;
            }
        }

        return longestSubstrLen;
    }
}
