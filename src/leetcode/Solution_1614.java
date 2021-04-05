package leetcode;

public class Solution_1614 {

    public static void main(final String[] args) {
        final int ans = new Solution_1614().maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(ans);
    }

    public int maxDepth(final String s) {
        int maxDepth = 0, currentDepth = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                currentDepth++;
                maxDepth = Math.max(currentDepth, maxDepth);
            } else if (s.charAt(i) == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

//    public int maxDepth(final String s) {
//        final Stack<Character> stack = new Stack<>();
//        int maxDepth = 0, currentDepth = 0;
//
//        for (int i = 0; i < s.length(); ++i) {
//            if (s.charAt(i) == '(') {
//                stack.add('(');
//                currentDepth++;
//                maxDepth = Math.max(currentDepth, maxDepth);
//            } else if (s.charAt(i) == ')') {
//                stack.pop();
//                currentDepth--;
//            } else {
//                // noop
//            }
//        }
//
//        return maxDepth;
//    }
}
