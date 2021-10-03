package ro.corden.trie_phrase;

import ro.corden.trie_phrase.core.Trie;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String... args) {
        Trie trie = new Trie();
        trie.insertPhrase("ana are mere");
        trie.insertPhrase("mihai merge la piata");
        trie.insertPhrase("citeste");
        trie.insertPhrase("lucreaza azi");

        String testPhrase = "Ana are mere si merge la piata, citeste asta lucreaza azi";
        trie.initSearchPhraseByWord();
        int start = 0;
        int end = -1;
        var phrase = Arrays.asList(testPhrase.toLowerCase(Locale.ROOT).trim().split(" "));
        for (var word : testPhrase.toLowerCase(Locale.ROOT).trim().split(" ")) {
            var result = trie.searchPhraseByWord(word);
            if (result == null) {
                trie.initSearchPhraseByWord();
                start = testPhrase.indexOf(word);
            } else {
                if (result == Trie.PartialSearchResult.IS_FULL_PHRASE) {
                    end = testPhrase.indexOf(word) + word.length();
                    System.out.printf("Found phrase (start: %s) - (end: %s).%n", start, end);
                    start = end + 1;
                }
            }
        }


        return;
    }
}
