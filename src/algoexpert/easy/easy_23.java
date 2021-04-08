package algoexpert.easy;

public class easy_23 {

    public String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder(string.length());
        int i = 0;

        while (i < string.length()) {
            int count = 1;
            char c = string.charAt(i);
            i++;

            while (i < string.length() && string.charAt(i) == c) {
                if (count == 9) {
                    break;
                }

                count++;
                i++;
            }

            sb.append(count);
            sb.append(c);
        }


        return sb.toString();
    }
}
