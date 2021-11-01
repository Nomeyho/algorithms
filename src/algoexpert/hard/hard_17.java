package algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class hard_17 {
    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> result = new ArrayList<>();
        generateDivTags(numberOfTags, numberOfTags, "", result);
        return result;
    }

    public void generateDivTags(int opening, int closing, String prefix, List<String> result) {

        if (opening > 0) {
            generateDivTags(opening - 1, closing, prefix + "<div>", result);
        }

        if (opening < closing) {
            generateDivTags(opening, closing - 1, prefix + "</div>", result);
        }

        if (closing == 0) {
            result.add(prefix);
        }
    }
}
