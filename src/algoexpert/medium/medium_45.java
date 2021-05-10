package algoexpert.medium;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class medium_45 {

    private static Set<Character> OPENING = Set.of('(', '[', '{');
    private static Set<Character> CLOSING = Set.of(')', ']', '}');
    private static Map<Character, Character> PAIRS = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (OPENING.contains(c)) {
                stack.add(c);
            } else if (CLOSING.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (PAIRS.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
