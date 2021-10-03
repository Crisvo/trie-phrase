package ro.corden.trie_phrase;

import ro.corden.trie_phrase.core.Trie;

public class Main {
    public static void main(String... args){
        Trie trie = new Trie();
        trie.insertPhrase("ana are mere");
        trie.insertPhrase("mihai merge la piata");
        trie.insertPhrase("citeste");
        trie.insertPhrase("lucreaza azi");

        trie.containsPhrase("ana are mere");

        return;
    }
}
