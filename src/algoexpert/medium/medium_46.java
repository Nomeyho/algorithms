package algoexpert.medium;

import java.util.ArrayList;
import java.util.Collections;

public class medium_46 {

    public static void main(String[] args) {
        ArrayList<Integer> result = new medium_46().sunsetViews(
                new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"
        );

        System.out.println(result);
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = direction.equals("WEST") ? 0 : buildings.length - 1;
        int step = direction.equals("WEST") ? 1 : -1;
        int maxHeight = - 1;
        
        for (int i = start; i >= 0 && i <= buildings.length; i += step) {
            if (buildings[i] > maxHeight) {
                result.add(i);
            }
            maxHeight = Math.max(maxHeight, buildings[i]);
        }
        
        if (direction.equals("EAST")) {
            Collections.reverse(result);
        }

        return result;
    }
}
