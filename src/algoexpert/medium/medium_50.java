package algoexpert.medium;

public class medium_50 {

    private static final char SPACE = ' ';

    // 0(n^2) time because of the string concatenations
    // See AlgoExpert for O(n) time complexity
    // Idea: reverse full string and re-reverse words (in place) afterwards
    public String reverseWordsInString(String string) {
        String reversedString = "";
        int i = 0;

        while (i < string.length()) {
            int wordStart = i;
            while (i < string.length() && string.charAt(i) != SPACE) {
                i++;
            }
            reversedString = string.substring(wordStart, i) + reversedString;

            int spaceStart = i;
            while (i < string.length() && string.charAt(i) == SPACE) {
                i++;
            }
            reversedString = string.substring(spaceStart, i) + reversedString;
        }

        return reversedString;
    }
}
