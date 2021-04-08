package algoexpert.easy;

public class easy_22 {

    public static void main(final String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // O(n) space in Java because Strings are immutables
        final char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            chars[i] = encode(chars[i], key);
        }

        return new String(chars);
    }

    private static char encode(char c, int key) {
        // ['a'; 'z'] = [97; 122]
        c -= 'a'; // [0; 25]
        c += key; // [key; 25 + key]
        c %= ('z' - 'a' + 1); // [0; 25]
        c += 'a'; // [97; 122]
        return c;
    }
}
