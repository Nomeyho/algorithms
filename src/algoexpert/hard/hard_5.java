package algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class hard_5 {
    
    public static void main(String[] args) {
        List<Integer> result = zigzagTraverse(
                List.of(
                        List.of(1, 3, 4, 10, 11),
                        List.of(2, 5, 9, 12, 19),
                        List.of(6, 8, 13, 18, 20),
                        List.of(7, 14, 17, 21, 24),
                        List.of(15, 16, 22, 23, 25)
                )
        );
        System.out.println(result);
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int I = array.size();
        int J = array.get(0).size();
        List<Integer> result = new ArrayList<>(I * J);

        int i = 0;
        int j = 0;
        boolean down = true;

        while (i != I && j != J) {
            result.add(array.get(i).get(j));

            if (down) {
                if (j == 0 || i == I - 1) {
                    if(i == I - 1) {
                        j++;
                    } else {
                        i++;
                    }
                    down = false;
                } else {
                    // diagonal
                    i++;
                    j--;
                }
            } else {
                if (i == 0 || j == J - 1) {
                    if (j == J - 1) {
                        i++;
                    } else {
                        j++;
                    }
                    down= true;
                } else {
                    // diagonal
                    i--;
                    j++;
                }
            }
        }

        return result;
    }
}
