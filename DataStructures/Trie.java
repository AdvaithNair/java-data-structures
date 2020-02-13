package DataStructures;

import java.util.*;

public class Trie {
    private class TrieNode {
        private char character;
        private boolean isCompleteWord;
        private HashMap<Character, TrieNode> children = new HashMap();

        public TrieNode() {}

        public TrieNode(char c){
            this.character = c; //Sets Character
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children; //Returns Children of Node
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children; //Passes Child to Node
        }

        public boolean isCompleteWord() {
            return isCompleteWord; //Returns Word Completeness
        }

        public void setCompleteness(boolean isCompleteWord) {
            this.isCompleteWord = isCompleteWord; //Sets New Word Completeness
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            TrieNode node;

            //Traverses Pre-existing Characters
            if(children.containsKey(temp))
                node = children.get(temp);

            //Adds New Characters
            else {
                node = new TrieNode(temp);
                children.put(temp, node);
            }

            children = node.getChildren(); //Traversal

            if(i == word.length() - 1)
                node.setCompleteness(true);
        }
    }

    public boolean searchWord(String word) {
        HashMap<Character, TrieNode> children = root.getChildren(); //temp children

        TrieNode node = null; //Traversal/comparison node
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);

            //if this character is part of the trie, continue
            if(children.containsKey(temp)) {
                node = children.get(temp);
                children = node.getChildren();
            }

            //otherwise, break and return false
            else {
                System.out.println("Fragment " + word + " Not Found.");
                return false;
            }
        }

        if (node != null && node.isCompleteWord())
            System.out.println("Word " + word + " Found.");
        else
            System.out.println("Word " + word + " Not Found.");
        return (node != null && node.isCompleteWord());
    }

    public boolean searchFragment(String word) {
        HashMap<Character, TrieNode> children = root.getChildren(); //temp children

        TrieNode node = null; //Traversal/comparison node
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);

            //if this character is part of the trie, continue
            if(children.containsKey(temp)) {
                node = children.get(temp);
                children = node.getChildren();
            }

            //otherwise, break and return false
            else {
                System.out.println("Fragment " + word + " Not Found.");
                return false;
            }
        }

        if (node != null)
            System.out.println("Fragment " + word + " Found.");
        else
            System.out.println("Fragment " + word + " Not Found.");
        return (node != null);
    }

    public static void main(String[] args) {
        /*char te = 'a';
        System.out.println(te);
        System.out.println(++te);*/
    }
}
