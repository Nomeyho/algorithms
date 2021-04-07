package algoexpert.easy;

import java.util.Arrays;

class easy_12 {

    public int tandemBicycle(
            int[] redShirtSpeeds,
            int[] blueShirtSpeeds,
            boolean fastest
    ) {
        final int len = redShirtSpeeds.length;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int sum = 0;

        for (int i = 0; i < len; ++i) {
            sum += Math.max(
                    redShirtSpeeds[i],
                    blueShirtSpeeds[fastest ? len - i - 1 : i]
            );
        }

        return sum;
    }
}

