package algoexpert;

class easy_14 {

    public static int getNthFib(int n) {
        if (n <= 2) {
            return n - 1;
        }

        int a = 0; // F_n-1
        int b = 1; // F_n-2
        int tmp;

        for (int i = 2; i < n; ++i) {
            tmp = a + b;
            b = a;
            a = tmp;
        }

        return a + b;
    }
}

