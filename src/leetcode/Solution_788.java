package leetcode;

public class Solution_788 {
    
    private static final Integer[] ROTATIONS = new Integer[]{ 0, 1, 5, null, null, 2, 9, null, 8, 6 };

    public static void main(final String[] args) {
        final int count = new Solution_788().rotatedDigits(10);
        System.out.println(count);
    }

    public int rotatedDigits(final int N) {
        int count = 0;

        for (int n = 1; n <= N; ++n) {
            final Integer rotatedDigit = rotate(n);

            if (rotatedDigit != null && rotatedDigit != n) {
                // System.out.println(n + " -> " + rotatedDigit);
                count++;
            }
        }

        return count;
    }

    private static Integer rotate(final int n) {
        final int[] digits = toDigits(n);

        for (int i = 0; i < digits.length; ++i) {
            final int digit = digits[i];
            final Integer rotatedDigit = ROTATIONS[digit];

            if (rotatedDigit == null) {
                return null;
            } else {
                digits[i] = rotatedDigit;
            }
        }

        return fromDigits(digits);
    }

    private static int[] toDigits(final int n) {
        final String s = n + "";
        final int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            digits[i] = s.charAt(i) - '0';
        }

        return digits;
    }

    private static int fromDigits(final int[] digits) {
        int n = 0;

        for(int i = 0; i < digits.length; ++i) {
            n += digits[i] * (int) Math.pow(10, digits.length-1-i);
        }

        return n;
    }
}