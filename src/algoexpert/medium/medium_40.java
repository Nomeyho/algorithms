package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class medium_40 {

    private static final Map<Character, List<Character>> KEYPAD = Map.of(
            '0', List.of('0'),
            '1', List.of('1'),
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> phoneNumberMnemonics(String phoneNumber) {
        List<String> mnemonics = new ArrayList<>();
        mnemonics.add("");

        for (int i = 0; i < phoneNumber.length(); i++) { // O(n)
            char digit = phoneNumber.charAt(i);
            List<Character> chars = KEYPAD.get(digit);
            List<String> newMnemonics = new ArrayList<>();

            for (String mnemonic : mnemonics) { // O(4 ^ n)
                for (char c : chars) { // O(4)
                    newMnemonics.add(mnemonic + c);
                }
            }

            mnemonics = newMnemonics;
        }

        return mnemonics;
    }
}
