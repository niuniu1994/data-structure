package leetcode;

import java.util.TreeMap;

public class WordDictionary {
    private class Node{
        Boolean isWord;
        TreeMap<Character, Node> next;

        public Node(Boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            isWord = false;
            next = new TreeMap<>();
        }
    }
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word){
        int l = word.length();
        add(word,root,l,0);
    }

    private void add(String word,Node cur,int l,int c){
        if(c == l){
            if(!cur.isWord){
                cur.isWord = true;
            }
            return;
        }

        if(!cur.next.containsKey(word.charAt(c)))
            cur.next.put(word.charAt(c),new Node());
        add(word,cur.next.get(word.charAt(c)),l,c +=1);

    }

    public Boolean search(String word){
        return contains(word,root,0);
    }

    private Boolean contains(String word, Node cur,int c){
        if(word.length() == c){
            return cur.isWord;
        }

        char ch = word.charAt(c);
        if (ch != '.'){
            if(cur.next.containsKey(ch))
                return contains(word,cur.next.get(ch), c + 1);
        }else {
            for (char ck : cur.next.keySet()) {
                if (contains(word, cur.next.get(ck), c + 1))
                    return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("abc");
        wordDictionary.addWord("acb");
        System.out.println(wordDictionary.search("a.."));
    }
}
