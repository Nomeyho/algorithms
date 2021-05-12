package algoexpert.medium;

import java.util.ArrayList;

public class medium_51 {

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ips = new ArrayList<>();
        int len = string.length();

        // O(n) time!
        // O(1) space, not considering the output
        for (int i = 0; i < Math.min(4, len); ++i) {
            String a = string.substring(0, i);
            if(!isValidPart(a)) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(4, len - i); ++j) {
                String b = string.substring(i, j);
                if(!isValidPart(b)) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(4, len - j); ++k) {
                    String c = string.substring(j, k);
                    String d = string.substring(k, len);

                    if(isValidPart(c) && isValidPart(d)) {
                        ips.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }

        return ips;
    }

    private static boolean isValidPart(String str) {
        if (str.length() == 0 || (str.charAt(0) == '0' && str.length() > 1)) {
            return false;
        }

        int number = Integer.parseInt(str);
        if (number > 255) {
            return false;
        }

        return true;
    }
}
