package com.datastructures.gtci.trie;

import java.util.Locale;

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

public class Trie {

    //    1. Will have a root node
    private TrieNode root;

    //    2. A constructor
    public Trie() {
        root = new TrieNode();
    }

    //    3. A method to insert
    public void insertWord(String word) {

        if (word == null || word.isEmpty())
            throw new IllegalArgumentException("Invalid input");

        word = word.toLowerCase();

        TrieNode current = root;
//        the word will be traversed till its length
        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a'; // diff b/w current char and 'a' will give the index value between 0 and 25.

            if (current.children[index] == null) {

//                create a new trieNode and assign it to this index
                TrieNode newNode = new TrieNode();
                current.children[index] = newNode;
                current = newNode;
            } else {
                current = current.children[index];
            }

        }
        current.isWord = true;


    }

    //    4. Search a word
    public boolean searchTheWord(String word) {

        if (word == null || word.isEmpty())
            return false;

        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return current.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("cat");
        trie.insertWord("car");
        trie.insertWord("son");
        trie.insertWord("so");

        System.out.println("values inserted");

        System.out.println("is cat present " + trie.searchTheWord("cat"));
        System.out.println("is cab present " + trie.searchTheWord("cab"));
        System.out.println("is son present " + trie.searchTheWord("son"));
        System.out.println("is sony present " + trie.searchTheWord("sony"));
        System.out.println("is so present " + trie.searchTheWord("so"));

    }

}


