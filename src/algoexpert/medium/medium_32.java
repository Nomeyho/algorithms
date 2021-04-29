package algoexpert.medium;

import java.util.*;

public class medium_32 {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, Queue<Integer>> indices = new HashMap<>();
        for (int i = 0; i < tasks.size(); ++i) {
            int task = tasks.get(i);

            if (!indices.containsKey(task)) {
                indices.put(tasks.get(i), new ArrayDeque<>());
            }

            indices.get(task).add(i);
        }

        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        Collections.sort(tasks);

        for (int i = 0; i < k; ++i) {
            int taskOne = tasks.get(i);
            int taskTwo = tasks.get(2 * k - i - 1);

            int indexOne = indices.get(taskOne).poll();
            int indexTwo = indices.get(taskTwo).poll();

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(indexOne);
            pair.add(indexTwo);
            pairs.add(pair);
        }

        return pairs;
    }

}
