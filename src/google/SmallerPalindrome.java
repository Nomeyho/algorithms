package google;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class SmallerPalindrome {
    
    private static final int MODULO = 1_000_000_000 + 7;

    /**
     * Google KickStart 2021 - Round C
     * Problem #1
     */
    public static void main(final String[] args) {
        final List<TestCase> testCases = parseTestCases();
        int i = 1;

        for (final TestCase testCase : testCases) {
            final int solution = solve(testCase);
            System.out.println("Case #" + (i++) + ": " + solution);
        }
    }

    private static class TestCase {
        int n;
        int k;
        String s;

        TestCase(int n, int k, String s) {
            this.n = n;
            this.k = k;
            this.s = s;
        }
    }
    
    private static List<TestCase> parseTestCases() {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); // TODO close
        final int numberTestCases = parseInt(in.nextLine());
        final List<TestCase> testCases = new LinkedList<>();

        for (int i = 0; i < numberTestCases; ++i) {
            final String[] nk = in.nextLine().split(" ");
            final String s = in.nextLine();
            testCases.add(new TestCase(parseInt(nk[0]), parseInt(nk[1]), s));
        }
        
        return testCases;
    }
    
    private static int solve(final TestCase testCase) {
        int result = 1;
        
        if (testCase.n == 1) {
            return testCase.s.charAt(0) - 'a';
        }
        
        for (int i = 0; i <= (testCase.n - 1) / 2; ++i) {
            int numberOfLetters = testCase.s.charAt(i) - 'a' + 1;

            if (numberOfLetters < 0) {
                return 0;
            }
            
            result = numberOfLetters + (result - 1) * testCase.k;
        }

        return result % MODULO;
    }
}
