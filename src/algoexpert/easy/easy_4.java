package algoexpert.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

class easy_4 {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions,
            ArrayList<Integer> results
    ) {
        final Map<String, Integer> points = new LinkedHashMap<>();

        for (int i = 0; i < results.size(); ++i) {
            final String winner = competitions.get(i).get(1 - results.get(i));
            final int currentPoints = points.getOrDefault(winner, 0);
            points.put(winner, currentPoints + 1);
        }

        return points.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }
}

