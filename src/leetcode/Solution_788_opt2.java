package leetcode;

public class Solution_788_opt2 {

    public static void main(final String[] args) {
        final int count = new Solution_788_opt2().rotatedDigits(2);
        System.out.println(count);
    }

    public int rotatedDigits(final int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isValidNumber(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isValidNumber(final int num) {
        boolean isValid = false;
        int n = num;
        
        while (n > 0) {
            int rem = n % 10;
            if (rem == 3 || rem == 4 || rem == 7) return false;
            else if (rem == 2 || rem == 5 || rem == 6 || rem == 9) isValid = true;
            n /= 10;
        }
        
        return isValid;
    }
}