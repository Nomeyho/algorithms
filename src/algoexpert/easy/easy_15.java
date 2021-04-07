package algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class easy_15 {
    public static int productSum(List<Object> array) {
        return productSumRec(array, 1);
    }

    @SuppressWarnings("unchecked")
    public static int productSumRec(List<Object> array, int depth) {
        int sum = 0;

        for (Object object : array) {
            if (object instanceof ArrayList) {
                sum += productSumRec((List<Object>) object, depth + 1);
            } else {
                sum += (int) object;
            }
        }

        return sum * depth;
    }
}
