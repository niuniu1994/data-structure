public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("panda");
        trie.add("pad");
        System.out.println(trie.contains("pa"));
        System.out.println(trie.prefixContains("pan"));
    }
}
