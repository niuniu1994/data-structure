package leetcode;

import com.sun.jdi.Value;

import java.util.TreeMap;

class MapSum {

    private class Node {
        int value;
        TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            value = 0;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        add(key, root, 0, val);
    }

    private void add(String word, Node cur, int c, int val) {
        if (c == word.length()) {
            cur.value = val;
            return;
        }

        if (!cur.next.containsKey(word.charAt(c)))
            cur.next.put(word.charAt(c), new Node());
        add(word, cur.next.get(word.charAt(c)), c + 1, val);
    }


    public int sum(String prefix) {
        return sum(prefix, root, 0,0);
    }

    private int sum(String prefix, Node cur, int index,int sum) {

        if (index < prefix.length()) {
            char c = prefix.charAt(index);
            if (cur.next.containsKey(c)) {
                return sum(prefix, cur.next.get(c), index + 1,sum);
            }
        }

        //这种求和用递归的题 如果吧和sum是一个参数的话，那每次递归都要初始化
        if (index >= prefix.length()) {
            sum = cur.value;
            for (char ch : cur.next.keySet()) {
                sum += sum(prefix, cur.next.get(ch), index,sum);
            }
        }

        return sum;
    }

    private int sum(Node node){
        int res = node.value;
        for (char ch : node.next.keySet()) {
            res += sum(node.next.get(ch));
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum =new MapSum();
        mapSum.insert("a",2);
        mapSum.insert("apple",2);
        mapSum.insert("app",5);
        mapSum.insert("aple", 6);
        System.out.println(mapSum.sum("ap"));


    }
}
