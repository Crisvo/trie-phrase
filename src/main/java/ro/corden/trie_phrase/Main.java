package ro.corden.trie_phrase;

import ro.corden.trie_phrase.core.Trie;

public class Main {
    public static void main(String... args){
        Trie trie = new Trie();
        trie.insertPhrase("ana are mere");
        trie.insertPhrase("mihai merge la piata");
        trie.insertPhrase("citeste");
        trie.insertPhrase("lucreaza azi");

        trie.initSearchPhraseByWord();
        var ana = trie.searchPhraseByWord("ana");
        var are = trie.searchPhraseByWord("are");
        var mere = trie.searchPhraseByWord("mere");



        return;
    }
}
