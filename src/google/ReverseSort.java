package google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseSort {

    /**
     * Google hashcode 2021 - problem #1
     */
    public static void main(final String[] args) {
        final LinkedList<Integer>[] testCases = parseTestCases();

        for (int i = 0; i < testCases.length; i++) {
            final int cost = computeReverseCost(testCases[i]);
            System.out.println("Case #" + (i + 1) + ": " + cost);
        }
    }

    private static LinkedList<Integer>[] parseTestCases() {
        // FIXME: sanity checks
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int numberTestCases = Integer.parseInt(in.nextLine());
        final LinkedList<Integer>[] testCases = new LinkedList[numberTestCases];

        for (int i = 0; i < numberTestCases; ++i) {
            in.nextLine(); // size
            final String line = in.nextLine();
            testCases[i] = Arrays.stream(line.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        in.close();
        return testCases;
    }
   
    private static int computeReverseCost(final LinkedList<Integer> testCase) {
        int cost = 0;
        int len = testCase.size();

        for (int i = 0; i < len - 1; ++i) {
            final int j = indexOfSmallest(testCase, i);
            Collections.reverse(testCase.subList(i, j + 1));
            cost += j - i + 1;
        }

        return cost;
    }

    private static int indexOfSmallest(final LinkedList<Integer> testCase, final int offset) {
        // FIXME: sanity checks
        int min = testCase.get(offset);
        int minIndex = offset;
        int index = offset;

        final ListIterator<Integer> it = testCase.listIterator(offset);
        while (it.hasNext()) {
            final Integer value = it.next();
            if (value < min) {
                min = value;
                minIndex = index;
            }
            ++index;
        }
        return minIndex;
    }
}
