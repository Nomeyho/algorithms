package algoexpert.easy;

import java.util.ArrayList;
import java.util.Collections;

class easy_11 {

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights,
            ArrayList<Integer> blueShirtHeights
    ) {
        final int size = redShirtHeights.size();
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        final ArrayList<Integer> backRow;
        final ArrayList<Integer> frontRow;
        if (redShirtHeights.get(size - 1) > blueShirtHeights.get(size - 1)) {
            backRow = redShirtHeights;
            frontRow = blueShirtHeights;
        } else {
            backRow = blueShirtHeights;
            frontRow = redShirtHeights;
        }

        for (int i = size - 1; i >= 0; --i) {
            if (backRow.get(i) <= frontRow.get(i)) {
                return false;
            }
        }

        return true;
    }
}

