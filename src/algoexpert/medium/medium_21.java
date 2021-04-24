package algoexpert.medium;

public class medium_21 {

    public static void main(final String[] args) {
        int result = numberOfWaysToMakeChange(6, new int[]{1, 5});
        System.out.println(result);
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] numberOfWays = new int[n + 1];
        numberOfWays[0] = 1;

        for (int denom : denoms) {
            for (int i = 1; i <= n; i++) {
                if (i - denom >= 0) {
                    numberOfWays[i] += numberOfWays[i - denom];
                }
            }
        }

        return numberOfWays[n];
    }
}