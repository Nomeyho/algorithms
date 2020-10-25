import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstrLen = 0;
        int startIndex = 0;
        boolean[] chars = new boolean[256];

        for (int i = startIndex; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (chars[c]) {
                // reset
                startIndex++;
                chars = new boolean[256];
                break;
            }

            longestSubstrLen++;
            chars[c] = true;
        }

        return longestSubstrLen;
    }
}
