package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium_9 {
    

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer[]> result = new ArrayList<>();
        result.add(new Integer[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; ++i) {
            Integer[] currentInterval = result.get(result.size() - 1);
            int[] interval = intervals[i];

            // overlap
            if (currentInterval[0] <= interval[0] && currentInterval[1] >= interval[0]) {
                // [a        b]
                //    [c d]
                if (interval[1] <= currentInterval[1]) {
                    // already fully included
                }
                // [a    b]
                //    [c     d]
                else {
                    currentInterval[1] = interval[1];
                }
            }
            // no-overlap
            else {
                result.add(new Integer[]{interval[0], interval[1]});
            }
        }

        return result.stream()
                .map(a -> new int[]{a[0], a[1]})
                .toArray(int[][]::new);
    }

}
