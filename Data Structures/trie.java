import java.util.*;

class TrieNode{
    boolean endOfWord;
    HashMap<Character,TrieNode> mapping;

    TrieNode(){
        endOfWord = false;
        mapping = new HashMap<>();
    }
}

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void addWord(String s){
        TrieNode p = root;
        for(int i=0;i<s.length();i++){
            if(!p.mapping.containsKey(s.charAt(i)))
                p.mapping.put(s.charAt(i), new TrieNode());    
            p = p.mapping.get(s.charAt(i));
        }
        p.endOfWord = true;
    }

    boolean searchWord(String s){
        TrieNode p = root;
        for(int i=0;i<s.length();i++){
            if(!p.mapping.containsKey(s.charAt(i)))
                return false;
            p = p.mapping.get(s.charAt(i));
        }
        return p.endOfWord;
    }
}