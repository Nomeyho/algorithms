package algoexpert.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static algoexpert.hard.hard_14.Direction.DIAGONAL;
import static algoexpert.hard.hard_14.Direction.LEFT;

class hard_14 {

    public static void main(String[] args) {
        String str1 = "ABCDEFG";
        String str2 = "ABCDEFG";

        System.out.println(longestCommonSubsequence(str1, str2));
    }

    enum Direction {LEFT, UP, DIAGONAL}

    private static class LCS {
        Direction direction;
        int length;

        LCS(Direction direction, int length) {
            this.direction = direction;
            this.length = length;
        }
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        LCS[][] lcs = init(str1.length(), str2.length());
        fill(lcs, str1, str2);
        return backtrack(lcs, str1, str2);
    }

    private static LCS[][] init(int M, int N) {
        LCS[][] lcs = new LCS[M + 1][N + 1];

        // init
        for (int i = 0; i <= M; i++) {
            lcs[i][0] = new LCS(null, 0);
        }

        for (int j = 0; j <= N; j++) {
            lcs[0][j] = new LCS(null, 0);
        }

        return lcs;
    }

    private static void fill(LCS[][] lcs, String str1, String str2) {
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = new LCS(DIAGONAL, lcs[i - 1][j - 1].length + 1);
                } else if (lcs[i][j - 1].length > lcs[i - 1][j].length) {
                    lcs[i][j] = new LCS(LEFT, lcs[i][j - 1].length);
                } else {
                    lcs[i][j] = new LCS(Direction.UP, lcs[i - 1][j].length);
                }
            }
        }
    }

    private static List<Character> backtrack(LCS[][] lcs, String str1, String str2) {
        List<Character> solution = new ArrayList<>();
        int i = str1.length();
        int j = str2.length();

        while (i != 0 && j != 0) {

            switch (lcs[i][j].direction) {
                case UP:
                    i--;
                    break;
                case LEFT:
                    j--;
                    break;
                case DIAGONAL:
                    i--;
                    j--;
                    solution.add(str1.charAt(i));
                    break;
            }
        }

        Collections.reverse(solution);
        return solution;
    }
}

