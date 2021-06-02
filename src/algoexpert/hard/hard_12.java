package algoexpert.hard;

public class hard_12 {

    public int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        int[] a = new int[array.length];
        int[] ab = new int[array.length];
        int[] abc = new int[array.length];
        int[] abcd = new int[array.length];

        // a
        a[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            a[i] = Math.max(a[i - 1], array[i]);
        }

        // a - b
        ab[0] = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            ab[i] = Math.max(
                    a[i - 1] - array[i],
                    ab[i - 1]
            );
        }

        // a - b + c
        abc[0] = Integer.MIN_VALUE;
        abc[1] = Integer.MIN_VALUE;
        for (int i = 2; i < array.length; i++) {
            abc[i] = Math.max(
                    ab[i - 1] + array[i],
                    abc[i - 1]
            );
        }

        // a - b + c - d
        abcd[0] = Integer.MIN_VALUE;
        abcd[1] = Integer.MIN_VALUE;
        abcd[2] = Integer.MIN_VALUE;
        for (int i = 3; i < array.length; i++) {
            abcd[i] = Math.max(
                    abc[i - 1] - array[i],
                    abcd[i - 1]
            );
        }

        return abcd[array.length - 1];
    }
}
