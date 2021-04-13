package algoexpert.medium;

public class medium_6 {

    public static void main(final String[] args) {
        final int result = longestPeak(new int[]{1, 3, 2});
        System.out.println(result);
    }
    
    public static int longestPeak(int[] array) {
        int longestPeak = 0;
        int i = 1;
        int peakStart = 0;
        boolean increasingPhase = true;

        while (i < array.length) {
            if (increasingPhase) {
                if (array[i - 1] < array[i]) {
                    // continue as long as elements are increasing
                    i++;
                } else if (array[i - 1] > array[i]) {
                    // first element to decrease
                    if (i - peakStart >= 2) {
                        // at least 2 increasing elements are required 
                        // to make the increasing part of a peak
                        increasingPhase = false;
                    } else {
                        peakStart = i;
                        i++;
                    }
                } else {
                    // same values, start a potential 
                    // new peak at the second occurrence
                    peakStart = i;
                    i++;
                }
            } else {
                if (array[i - 1] < array[i]) {
                    // reached the end of the peak
                    // (at least 3 elements guaranteed here)
                    longestPeak = Math.max(longestPeak, i - peakStart);
                    peakStart = i - 1;
                    increasingPhase = true;
                } else if (array[i - 1] > array[i]) {
                    if (i == array.length - 1) {
                        return Math.max(longestPeak, i - peakStart + 1);
                    }

                    // continue as long as elements are decreasing
                    i++;
                } else {
                    // reached the end of the peak
                    // (at least 3 elements guaranteed here)
                    longestPeak = Math.max(longestPeak, i - peakStart);
                    peakStart = i;
                    i++;
                    increasingPhase = true;
                }
            }
        }

        return longestPeak;
    }
}
