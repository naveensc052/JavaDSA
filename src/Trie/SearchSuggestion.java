package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestion {
    class TrieNode {
        TrieNode[] children;
        List<String> suggestions;

        TrieNode() {
            children = new TrieNode[26];
            suggestions = new ArrayList<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        Arrays.sort(products);
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode current = root;
        for (char c : searchWord.toCharArray()) {
            if (current == null) {
                result.add(new ArrayList<>());
            } 
            else {
                current = current.children[c - 'a'];
                if (current == null) {
                    result.add(new ArrayList<>());
                } 
                else{
                    result.add(current.suggestions);
                }
            }
        }

        return result;
    }

    private void insert(TrieNode root, String product) {
        TrieNode current = root;
        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.suggestions.add(product);
            Collections.sort(current.suggestions);
            if (current.suggestions.size() > 3) {
                current.suggestions.remove(3);
            }
        }
    }

    public static void main(String[] args) {
        SearchSuggestion solution = new SearchSuggestion();

        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        List<List<String>> result1 = solution.suggestedProducts(products1, searchWord1);
        System.out.println(result1);

        String[] products2 = {"havana"};
        String searchWord2 = "tatiana";
        List<List<String>> result2 = solution.suggestedProducts(products2, searchWord2);
        System.out.println(result2);
    }
}

