package ro.corden.trie_phrase.core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trie {
    public enum PartialSearchResult {
        IS_PARTIAL_PHRASE,
        IS_FULL_PHRASE
    }

    private TrieNode root;
    private List<String> partialPhraseSearching;

    public Trie() {
        root = new TrieNode();
        partialPhraseSearching = new LinkedList<>();
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

    private PartialSearchResult containsPhrasePartial(List<String> phrase) {
        TrieNode currentNode = root;

        for (var word : phrase) {
            TrieNode node = currentNode.getChildren().get(word);
            if (node == null) {
                return null;
            }
            currentNode = node;
        }
        if (currentNode.isPhrase()) {
            return PartialSearchResult.IS_FULL_PHRASE;
        } else {
            return PartialSearchResult.IS_PARTIAL_PHRASE;
        }
    }

    public PartialSearchResult searchPhraseByWord(String word) {
        this.partialPhraseSearching.add(word);
        return this.containsPhrasePartial(this.partialPhraseSearching);
    }

    public boolean treeIsEmpty() {
        return root == null;
    }

    public void deletePhrase(List<String> phrase) {
        // todo
    }

    public void initSearchPhraseByWord() {
        this.partialPhraseSearching = new LinkedList<>();
    }
}
