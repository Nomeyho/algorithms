package leetcode;

public class Solution_788_opt {
    private static final Integer[] ROTATIONS = new Integer[]{0, 1, 5, null, null, 2, 9, null, 8, 6};

    public static void main(final String[] args) {
        final int count = new Solution_788_opt().rotatedDigits(10);
        System.out.println(count);
    }

    public int rotatedDigits(final int N) {
        int count = 0;

        for (int n = 1; n <= N; ++n) {
            final Integer rotatedDigit = rotate(n);

            if (rotatedDigit != null && rotatedDigit != n) {
                System.out.println(n + " -> " + rotatedDigit);
                count++;
            }
        }

        return count;
    }

    private static Integer rotate(int n) {
        int rotatedNumber = 0;
        int i = 0;

        while (n > 0) {
            final int digit = n % 10;

            if (ROTATIONS[digit] == null) {
                return null;
            } else {
                rotatedNumber += ROTATIONS[digit] * Math.pow(10, i);
            }

            n = (n - digit) / 10;
            i++;
        }

        return rotatedNumber;
    }
}