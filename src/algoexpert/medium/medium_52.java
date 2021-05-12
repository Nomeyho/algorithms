package algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class medium_52 {

    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie("babc");
        System.out.println(trie);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            int len = str.length();
            
            for (int i = 0; i < len; ++i) {
                populateTrieFrom(str.substring(i, len));
            }
        }

        public void populateTrieFrom(String str) {
            TrieNode node = root;

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }

            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode node = root;

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }

            return node.children.containsKey(endSymbol);
        }
    }
}
