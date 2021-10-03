package ro.corden.trie_phrase.core;

import java.util.HashMap;

public class TrieNode {
    //region Members
    private HashMap<String, TrieNode> children = new HashMap<>();
    private String content;
    private boolean isPhrase;
    //endregion

    //region Constructors
    public TrieNode() {
    }

    public TrieNode(String content) {
        this.content = content;
        this.isPhrase = false;
    }

    public TrieNode(String content, boolean isPhrase) {
        this.content = content;
        this.isPhrase = isPhrase;
    }
    //endregion

    //region Getters and setters

    public HashMap<String, TrieNode> getChildren() {
        return children;
    }

    public String getContent() {
        return content;
    }

    public boolean isPhrase() {
        return isPhrase;
    }

    public void setEndOfPhrase(boolean phrase) {
        isPhrase = phrase;
    }

    //endregion
}
