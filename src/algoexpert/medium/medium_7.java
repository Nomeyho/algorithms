package algoexpert.medium;

public class medium_7 {
    public int[] arrayOfProducts(int[] array) {
        final int[] products = new int[array.length];
        final int[] leftProducts = new int[array.length];
        final int[] rightProducts = new int[array.length];

        leftProducts[0] = 1;
        rightProducts[array.length - 1] = 1;

        for (int i = 1; i < array.length; ++i) {
            leftProducts[i] = leftProducts[i - 1] * array[i - 1];
        }

        for (int i = array.length - 2; i >= 0; --i) {
            rightProducts[i] = rightProducts[i + 1] * array[i + 1];
        }

        for (int i = 0; i < array.length; ++i) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }
}
