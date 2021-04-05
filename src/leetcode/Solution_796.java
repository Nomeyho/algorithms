package leetcode;

public class Solution_796 {
    /*
        Example 1:
        Input: A = 'abcde', B = 'cdeab'
        Output: true
        
        Example 2:
        Input: A = 'abcde', B = 'abced'
        Output: false
     */

    public static void main(final String[] args) {
        final boolean result = new Solution_796().rotateString("abcde", "abced");
        System.out.println(result);
    }
    
    public boolean rotateString(final String s1, final String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        if(s1.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < s1.length(); ++i) {
            if(same(s1, s2, i)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Return true if s1 and s2 are equal starting from index 'j' in s2 (circular).
     */
    private static boolean same(final String s1, final String s2, int j) {
        final int len = s1.length();
        
        for(int i = 0; i < len; ++i) {
            if(s1.charAt(i) != s2.charAt((j + i) % len)) {
                return false;
            }
        }
        
        return true;
    }
}
