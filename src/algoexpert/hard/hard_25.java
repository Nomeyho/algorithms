package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hard_25 {
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        Result result = getLowestCommonManagerRec(topManager, reportOne, reportTwo);
        return result.manager;
    }

    public static Result getLowestCommonManagerRec(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        Result result = new Result(topManager, 0);

        // Recursive call
        for (OrgChart directReport : topManager.directReports) {
            Result childResult = getLowestCommonManagerRec(directReport, reportOne, reportTwo);

            if (childResult.count == 2) { // both report are found in the subtree
                return childResult;
            }

            result.count += childResult.count;
        }

        // Count
        if (topManager == reportOne || topManager == reportTwo) {
            result.count++;
        }

        return result;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            this.directReports.addAll(Arrays.asList(directReports));
        }
    }

    static class Result {
        OrgChart manager;
        int count;

        Result(OrgChart manager, int count) {
            this.manager = manager;
            this.count = count;
        }
    }
}
