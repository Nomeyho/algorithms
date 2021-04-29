package algoexpert.medium;

public class medium_33 {

    public static void main(String[] args) {
        int result = new medium_33().validStartingCity(
                new int[]{5, 25, 15, 10, 15},
                new int[]{1, 2, 1, 0, 3},
                10
        );
        System.out.println(result);
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int len = distances.length;
        int range = 0;
        int startCity = -1;

        for (int i = 0; i < len; ++i) {
            range += fuel[i] * mpg;

            if (range >= distances[i]) {
                if (startCity == -1) {
                    startCity = i;
                }
                range -= distances[i];
            } else {
                range = 0;
                startCity = -1;
            }
        }

        return startCity;
    }

}
