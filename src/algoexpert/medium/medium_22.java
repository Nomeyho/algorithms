package algoexpert.medium;

public class medium_22 {

    public static void main(final String[] args) {
        int result = minNumberOfCoinsForChange(6, new int[]{1, 5, 10});
        System.out.println(result);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int min[] = new int[n + 1];

        for (int amount = 1; amount <= n; amount++) {
            min[amount] = -1;
            
            for (int denom : denoms) {
                int remainder = amount - denom;

                if (remainder >= 0 && min[remainder] != -1) {
                    if (min[amount] == -1) {
                        min[amount] = 1 + min[remainder];
                    } else {
                        min[amount] = Math.min(min[amount], 1 + min[remainder]);
                    }
                }
            }

        }

        return min[n];
    }
}