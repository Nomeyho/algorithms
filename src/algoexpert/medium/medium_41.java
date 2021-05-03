package algoexpert.medium;

public class medium_41 {

    // Tabulation:
    // O(height * maxSteps) time
    // O(height) size
    // See AlgoExpert for an O(height) time complexity using a sliding window
    public int staircaseTraversal(int height, int maxSteps) {
        int[] numberWays = new int[height + 1];
        numberWays[0] = 1;
        numberWays[1] = 1;

        for (int h = 2; h <= height; h++) {
            for (int i = 1; i <= maxSteps; i++) {
                if (h - i >= 0) {
                    numberWays[h] += numberWays[h - i];
                }
            }
        }

        return numberWays[height];
    }
    
    /*
    without memoization
        O(maxSteps ^ height) time
        O(height) space
    
    with memoization/tabulation
        O(maxSteps * height) time
        O(height) space
    
    public int staircaseTraversal(int height, int maxSteps) {
        if (height < 0) {
            return 0;
        } else if (height <= 1) {
            return 1;
        }

        int sum = 0;

        for (int i = 1; i <= maxSteps; i++) {
            sum += staircaseTraversal(height - i, maxSteps);
        }

        return sum;
    }
     */
}
