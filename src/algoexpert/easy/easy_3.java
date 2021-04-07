package algoexpert.easy;

class easy_3 {
    public int[] sortedSquaredArray(int[] array) {
        final int[] result = new int[array.length];
        int i = array.length - 1; // index in result (descending order)
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int s1 = array[start] * array[start];
            int s2 = array[end] * array[end];
            if (s1 > s2) {
                result[i] = s1;
                start++;
            } else {
                result[i] = s2;
                end--;
            }
            i--;
        }

        return result;
    }
}

