package ro.corden.trie_phrase.core;

import java.util.Arrays;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertPhrase(String phrase) {
        var listPhrase = Arrays.asList(phrase.trim().split(" "));
        if (!listPhrase.isEmpty())
            this.insertPhrase(listPhrase);
    }

    public void insertPhrase(List<String> phrase) {
        var currentNode = root;

        for (var word : phrase) {
            currentNode = currentNode.getChildren().computeIfAbsent(word, c -> new TrieNode());
        }

        currentNode.setEndOfPhrase(true);
    }

    public boolean containsPhrase(String phrase) {
        var listPhrase = Arrays.asList(phrase.trim().split(" "));
        if (!listPhrase.isEmpty())
            return this.containsPhrase(listPhrase);
        return false;
    }

    public boolean containsPhrase(List<String> phrase) {
        TrieNode currentNode = root;

        for (var word : phrase) {
            TrieNode node = currentNode.getChildren().get(word);
            if (node == null) {
                return false;
            }
            currentNode = node;
        }
        return currentNode.isPhrase();
    }

    public boolean treeIsEmpty() {
        return root == null;
    }

    public void deletePhrase(List<String> phrase) {
        // todo
    }
}
