package google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AstronautGenerator {

    /**
     * Google KickStart 2021 - Round C
     * Problem #2
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
        int g;

        TestCase(int g) {
            this.g = g;
        }
    }

    private static List<TestCase> parseTestCases() {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); // TODO close
        final int numberTestCases = parseInt(in.nextLine());
        final List<TestCase> testCases = new LinkedList<>();

        for (int i = 0; i < numberTestCases; ++i) {
            final String line = in.nextLine();
            testCases.add(new TestCase(parseInt(line)));
        }
        
        return testCases;
    }

    private static int solve(final TestCase testCase) {
        int result = 0; // number of starting to reach exactly 'g' golds

        for (int k = 0; k <= testCase.g; k++) { // starting value
            for (int n = 0; n <= testCase.g; n++) { // number of days
                int golds = n * k + (n + n * n) / 2;
                if (golds == testCase.g) {
                    result++;
                }
            }
        }

        return result;
    }
}
