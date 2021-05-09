package algoexpert.medium;

public class medium_43 {

    public int[] threeNumberSort(int[] array, int[] order) {
        int indexOne = 0; // next spot for element order[0] (inc.)
        int indexTwo = 0; // next spot for element order[1] (inc.)
        int indexThree = array.length - 1; // next spot for element order[2] (dec.)

        while (indexTwo <= indexThree) {
            if (array[indexTwo] == order[0]) {
                swap(array, indexOne, indexTwo);
                indexOne++;
                indexTwo++;
            } else if (array[indexTwo] == order[1]) {
                indexTwo++;
            } else {
                swap(array, indexTwo, indexThree);
                indexThree--;
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
